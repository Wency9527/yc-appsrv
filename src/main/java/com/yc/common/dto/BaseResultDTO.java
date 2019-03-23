package com.yc.common.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class BaseResultDTO implements Serializable {
    private static final long serialVersionUID = -2851575899681582847L;

    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

    public BaseResultDTO(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        if(data != null) {
            this.data = data;
        }
    }

    public static BaseResultDTO ok() {
        return new BaseResultDTO(200, "success", null);
    }

    public static BaseResultDTO ok(Object data) {
        return new BaseResultDTO(200, "success", data);
    }

    public static BaseResultDTO ok(String msg, Object data) {
        return new BaseResultDTO(200, msg, data);
    }

    public static BaseResultDTO error(String msg) {
        return new BaseResultDTO(500, msg, null);
    }

    public static BaseResultDTO error(Integer status, String msg) {
        return new BaseResultDTO(status, msg, null);
    }

}
