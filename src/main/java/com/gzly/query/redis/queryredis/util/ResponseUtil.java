package com.gzly.query.redis.queryredis.util;

import com.gzly.query.redis.queryredis.entity.ResponseVo;

/**
 * @author lzk
 * @date 2018/8/6
 */
public class ResponseUtil {

    public static ResponseVo getSuccess() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult(true);
        responseVo.setMessage("");
        responseVo.setCode(200);
        return responseVo;
    }
    public static ResponseVo getSuccess(Object o) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult(true);
        responseVo.setMessage("");
        responseVo.setCode(200);
        responseVo.setData(o);
        return responseVo;
    }
    public static ResponseVo getSuccess(Object o, String message) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult(true);
        responseVo.setMessage("");
        responseVo.setCode(200);
        responseVo.setData(o);
        responseVo.setMessage(message);
        return responseVo;
    }
    public static ResponseVo getFail(String message) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult(false);
        responseVo.setMessage(message);
        responseVo.setCode(700);
        return responseVo;
    }
    public static ResponseVo getFail() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult(false);
        responseVo.setCode(700);
        return responseVo;
    }
}
