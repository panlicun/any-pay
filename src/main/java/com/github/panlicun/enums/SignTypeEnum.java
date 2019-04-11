package com.github.panlicun.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 签名方式.
 * <p>
 * 即时到账(老接口)支持MD5和RSA的签名方式, App支付和Wap支付支持RSA和RSA2的签名方式. DSA签名方式暂时不支持.
 */
public enum SignTypeEnum {
    MD5, RSA, RSA2;

    private static Map<String, SignTypeEnum> values = new HashMap<>();

    static {
        for (SignTypeEnum value : values()) {
            values.put(value.name(), value);
        }
    }

    public static SignTypeEnum from(String strValue) {
        SignTypeEnum value = values.get(strValue);
        if (value != null) {
            return value;
        } else {
            return null;
        }
    }

    public static SignTypeEnum from(String strValue, SignTypeEnum defaultValue) {
        SignTypeEnum value = from(strValue);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public String toString() {
        return this.name();
    }

}
