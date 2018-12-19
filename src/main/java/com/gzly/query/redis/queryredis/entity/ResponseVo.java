package com.gzly.query.redis.queryredis.entity;

/**
 * @author lzk
 * @date 2018/8/6
 */
public class ResponseVo {

    private String message;
    private boolean result;
    private Object data;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
