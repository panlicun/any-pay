package com.github.panlicun.enums;


import com.github.panlicun.exception.BestPayException;

/**
 * 支付方式
 * Created by null on 2017/2/14.
 */
public enum BestPayTypeEnum {

    ALIPAY_APP("alipay_app", "支付宝app"),

    ALIPAY_PC("alipay_pc", "支付宝pc"),

    ALIPAY_WAP("alipay_wap", "支付宝wap"),

    WXPAY_H5("wxpay_h5", "微信H5支付"),

    WXPAY_APP("wxpay_app", "微信app支付"),

    ;

    private String code;

    private String name;

    BestPayTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static BestPayTypeEnum getByCode(String code) {
        for (BestPayTypeEnum bestPayTypeEnum : BestPayTypeEnum.values()) {
            if (bestPayTypeEnum.getCode().equals(code)) {
                return bestPayTypeEnum;
            }
        }
        throw new BestPayException(BestPayResultEnum.PAY_TYPE_ERROR);
    }
}
