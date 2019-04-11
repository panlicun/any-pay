package com.github.panlicun.model;


/**
 * 订单关闭返回的参数
 */
public class CloseOrderResponse {

    /**
     * 订单状态
     */
    private String resultCode;

    /**
     * 错误原因
     */
    private String resultMsg;



    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
