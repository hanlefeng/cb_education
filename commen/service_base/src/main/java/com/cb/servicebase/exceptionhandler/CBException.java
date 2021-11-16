package com.cb.servicebase.exceptionhandler;

import lombok.Data;

@Data
public class CBException extends RuntimeException{
    private Integer code;
    private String msg;

    public CBException() {
    }

    public CBException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
