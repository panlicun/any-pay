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
}
