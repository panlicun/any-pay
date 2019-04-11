package com.github.panlicun.model.alipay.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "xml", strict = false)
public class AliPayRequest {

    @Element(name = "app_id")
    private String appId;

    @Element(name = "mch_id")
    private String mchId;

    @Element(name = "charset")
    private String charset;

    @Element(name = "sign_type")
    private String signType;

    @Element(name = "sign")
    private String sign;

    @Element(name = "timestamp")
    private String timestamp;

    @Element(name = "version")
    private String version;

    @Element(name = "notify_url")
    private String notifyurl;

    @Element(name = "total_amount")
    private Integer totalAmount;

    @Element(name = "subject")
    private String subject;

    @Element(name = "out_trade_no")
    private String outTradeNo;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
