package com.github.panlicun.pay.wxpay;

import com.github.panlicun.model.wxpay.response.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface WxPayApi {

    /**
     * 统一下单
     * @param body
     * @return
     */
    @POST("/pay/unifiedorder")
    Call<WxPaySyncResponse> unifiedorder(@Body RequestBody body);

    /**
     * 申请退款
     * @param body
     * @return
     */
    @POST("/secapi/pay/refund")
    Call<WxRefundResponse> refund(@Body RequestBody body);

    /**
     * 申请沙箱密钥
     * @param body
     * @return
     */
    @POST("/sandboxnew/pay/getsignkey")
    Call<WxPaySandboxKeyResponse> getsignkey(@Body RequestBody body);

    /**
     * 订单查询
     * @param body
     * @return
     */
    @POST("/pay/orderquery")
    Call<WxOrderQueryResponse> orderquery(@Body RequestBody body);


    /**
     * 下载对账单
     * @param body
     * @return
     */
    @POST("/pay/downloadbill")
    Call<ResponseBody> downloadBill(@Body RequestBody body);

    /**
     * 关闭订单
     * @param body
     * @return
     */
    @POST("/pay/closeorder")
    Call<WxCloseOrderResponse> closeOrder(@Body RequestBody body);


}
