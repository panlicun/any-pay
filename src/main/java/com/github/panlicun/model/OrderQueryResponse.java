package com.github.panlicun.model;

import com.github.panlicun.enums.OrderStatusEnum;

/**
 * 订单查询结果
 * Created by 廖师兄
 * 2018-06-04 16:52
 */
public class OrderQueryResponse {

    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatusEnum;

    /**
     * 错误原因
     */
    private String resultMsg;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单金额
     */
    private Double orderAmount;


    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
