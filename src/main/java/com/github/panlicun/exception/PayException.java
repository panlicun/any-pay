package com.github.panlicun.exception;


import com.github.panlicun.enums.PayResultEnum;

/**
 * Created by null on 2017/2/23.
 */
public class PayException extends RuntimeException {

    private Integer code;

    public PayException(PayResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
