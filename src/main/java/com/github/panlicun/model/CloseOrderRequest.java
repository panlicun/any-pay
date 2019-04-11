package com.github.panlicun.model;



/**
 * 支付时请求参数
 */
public class CloseOrderRequest {

    /**
     * 订单号.
     */
    private String orderNo;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
