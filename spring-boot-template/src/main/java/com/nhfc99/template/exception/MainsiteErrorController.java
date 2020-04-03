package com.nhfc99.template.exception;

import com.nhfc99.template.utils.JSONResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainsiteErrorController implements ErrorController {
    @RequestMapping("/error")
    @ResponseBody
    public Object handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 404){
            JSONResult resultFormat = JSONResult.result(404, "找不到页面了");
            return resultFormat;
        } else {
            return null;
        }
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
