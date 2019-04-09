package com.github.panlicun.model.wxpay.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "xml", strict = false)
public class WxDownloadBillRequest {

    //公众账号ID
    @Element(name = "appid")
    private String appid;

    //商户号
    @Element(name = "mch_id")
    private String mchId;

    //随机字符串
    @Element(name = "nonce_str")
    private String nonceStr;

    //签名
    @Element(name = "sign")
    private String sign;

    //对账单日期
    @Element(name = "bill_date")
    private String billDate;

    //账单类型
    @Element(name = "bill_type", required = false)
    private String billType = "ALL";

//    //压缩账单
//    @Element(name = "tar_type", required = false)
//    private String tarType = "GZIP";


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }
}
