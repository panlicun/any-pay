package com.github.panlicun.pay.wxpay;

import com.github.panlicun.model.PayRequest;
import com.github.panlicun.model.PayResponse;

public interface WxPay {

    PayResponse unifiedorder(PayRequest request);

}
