package com.github.panlicun.model;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import lombok.Data;

/**
 * 支付订单查询
 * Created by 廖师兄
 * 2018-05-31 17:52
 */
@Data
public class OrderQueryRequest {

    /**
     * 支付方式.
     */
    private BestPayTypeEnum payTypeEnum;

    /**
     * 订单号(orderId 和 outOrderId 二选一，两个都传以outOrderId为准)
     */
    private String orderId = "";

    /**
     * 外部订单号(例如微信生成的)
     */
    private String outOrderId = "";
}
