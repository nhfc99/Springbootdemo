package com.nhfc99.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhfc99.test.exception.MyException;

@Controller
@RequestMapping("/test/exception")
public class ExceptionController {
    @ResponseBody
    @GetMapping("index")
    public String Index() {
        try {
            int number = 1 / 0;
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw new MyException(0, "不可以为0");
        }

        return "ceshi";
    }
}
