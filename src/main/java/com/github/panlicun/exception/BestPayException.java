package com.github.panlicun.exception;


import com.github.panlicun.enums.BestPayResultEnum;

/**
 * Created by null on 2017/2/23.
 */
public class BestPayException extends RuntimeException {

    private Integer code;

    public BestPayException(BestPayResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}