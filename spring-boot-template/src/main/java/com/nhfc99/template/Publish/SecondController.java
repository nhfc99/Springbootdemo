package com.nhfc99.template.Publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nhfc99/publish/second")
public class SecondController {
    @Autowired
    IndexController indexController;

    @GetMapping("/list")
    @ResponseBody
    public String initView() {
        return "list成功了";
    }
}
