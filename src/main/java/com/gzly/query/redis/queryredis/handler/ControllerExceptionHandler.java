package com.gzly.query.redis.queryredis.handler;

import com.gzly.query.redis.queryredis.entity.ResponseVo;
import com.gzly.query.redis.queryredis.util.ResponseUtil;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lzk
 * @date 2018/8/6
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVo handleException(HttpServletRequest request, Exception e) {

//        System.out.println("=======" + e.getMessage());
//        e.printStackTrace();

        if(e instanceof MethodArgumentNotValidException) {
            return ResponseUtil.getFail("传参错误");
        }

        return ResponseUtil.getFail();
    }
}
