package com.github.panlicun.pay.wxpay;

import com.github.panlicun.model.*;

public interface WxPay {

    /**
     * 统一下单接口
     * @param request
     * @return
     */
    PayResponse unifiedorder(PayRequest request);

    /**
     * 异步回调
     * @param notifyData
     * @return
     */
    PayResponse asyncNotify(String notifyData);

    /**
     * 退款
     * @param request
     * @return
     */
    RefundResponse refund(RefundRequest request);

    /**
     * 查询订单
     * @param request
     * @return
     */
    OrderQueryResponse query(OrderQueryRequest request);

    /**
     * 关闭订单
     * @param request
     * @return
     */
    CloseOrderResponse closeOrder(CloseOrderRequest request);



}
