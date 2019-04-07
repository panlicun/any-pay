package com.github.panlicun.pay.wxpay.impl;

import com.github.panlicun.config.WxAppPayConfig;
import com.github.panlicun.constants.WxPayConstants;
import com.github.panlicun.model.PayRequest;
import com.github.panlicun.model.PayResponse;
import com.github.panlicun.model.wxpay.request.WxPayUnifiedorderRequest;
import com.github.panlicun.model.wxpay.response.WxPaySyncResponse;
import com.github.panlicun.pay.wxpay.WxPay;
import com.github.panlicun.pay.wxpay.WxPayApi;
import com.github.panlicun.utils.MapUtil;
import com.github.panlicun.utils.PayUtil;
import com.github.panlicun.utils.RandomUtil;
import com.github.panlicun.utils.XmlUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WxAppPay implements WxPay {

    private WxAppPayConfig wxAppPayConfig;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(WxPayConstants.WXPAY_GATEWAY)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(new OkHttpClient.Builder()
                    .addInterceptor((new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)))
                    .build()
            )
            .build();


    @Override
    public PayResponse unifiedorder(PayRequest request) {
        WxPayUnifiedorderRequest wxRequest = new WxPayUnifiedorderRequest();
        wxRequest.setOutTradeNo(request.getOrderId());
        wxRequest.setTotalFee(request.getOrderAmount().movePointRight(2).intValue());
        wxRequest.setBody(request.getOrderName());
        wxRequest.setOpenid(request.getOpenid());

        wxRequest.setTradeType(new PayUtil().switchH5TradeType(request.getPayTypeEnum()));
        wxRequest.setAppid(wxAppPayConfig.getAppId());
        wxRequest.setMchId(wxAppPayConfig.getMchId());
        wxRequest.setNotifyUrl(wxAppPayConfig.getNotifyUrl());
        wxRequest.setNonceStr(RandomUtil.getRandomStr());
        wxRequest.setSpbillCreateIp(request.getSpbillCreateIp() == null || request.getSpbillCreateIp().isEmpty() ? "8.8.8.8" : request.getSpbillCreateIp());
        wxRequest.setSign(new PayUtil().sign(MapUtil.buildMap(wxRequest), wxAppPayConfig.getMchKey()));

        RequestBody body = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), XmlUtil.toString(wxRequest));
        Call<WxPaySyncResponse> call = retrofit.create(WxPayApi.class).unifiedorder(body);
        Response<WxPaySyncResponse> retrofitResponse  = null;
        try{
            retrofitResponse = call.execute();
        }catch (IOException e) {
            e.printStackTrace();
        }
        if (!retrofitResponse.isSuccessful()) {
            throw new RuntimeException("【微信统一支付】发起支付, 网络异常");
        }
        WxPaySyncResponse response = retrofitResponse.body();

        if(!response.getReturnCode().equals(WxPayConstants.SUCCESS)) {
            throw new RuntimeException("【微信统一支付】发起支付, returnCode != SUCCESS, returnMsg = " + response.getReturnMsg());
        }
        if (!response.getResultCode().equals(WxPayConstants.SUCCESS)) {
            throw new RuntimeException("【微信统一支付】发起支付, resultCode != SUCCESS, err_code = " + response.getErrCode() + " err_code_des=" + response.getErrCodeDes());
        }

        return buildPayResponse(response);
    }

    /**
     * 返回给h5的参数
     * @param response
     * @return
     */
    private PayResponse buildPayResponse(WxPaySyncResponse response) {
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String nonceStr = RandomUtil.getRandomStr();
        String signType = "MD5";

        //先构造要签名的map
        Map<String, String> map = new HashMap<>();
        map.put("appId", response.getAppid());
        map.put("partnerid", wxAppPayConfig.getMchId());
        map.put("prepayid", response.getPrepayId());
        map.put("package", "Sign=WXPay");
        map.put("noncestr", nonceStr);
        map.put("timestamp", timeStamp);

        PayResponse payResponse = new PayResponse();
        payResponse.setAppId(response.getAppid());
        payResponse.setPartnerid(wxAppPayConfig.getMchId());
        payResponse.setPrepayid(response.getPrepayId());
        payResponse.setPackAge("Sign=WXPay");
        payResponse.setNonceStr(nonceStr);
        payResponse.setTimeStamp(timeStamp);
        payResponse.setPaySign(new PayUtil().sign(map, wxAppPayConfig.getMchKey()));
        return payResponse;
    }
}
