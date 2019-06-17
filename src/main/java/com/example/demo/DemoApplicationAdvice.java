package com.example.demo;

import com.example.demo.customException.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DemoApplicationAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return  也可以返回responseBase  对象
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 1001231231);
        map.put("msg", ex.getMessage());
        return map;
    }

      /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return  也可以返回responseBase  对象
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public Map myErrorHandler(MyException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }





}
