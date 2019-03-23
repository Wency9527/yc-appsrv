package com.yc.common.exception;

import lombok.Data;

@Data
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -7631250307672299476L;

    private int status = 500;
    private String msg;

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CommonException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CommonException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.status = code;
    }

    public CommonException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.status = code;
    }

}
