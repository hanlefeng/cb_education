package com.cb.servicebase.exceptionhandler;



import com.cb.commentuils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exception(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局处理异常");
    }
    @ExceptionHandler(CBException.class)
    @ResponseBody
    public R exception(CBException e){
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
