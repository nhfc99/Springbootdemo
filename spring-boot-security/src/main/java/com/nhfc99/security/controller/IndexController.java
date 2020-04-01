package com.nhfc99.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index")
@RestController
public class IndexController {

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public String index() {
        return "test";
    }
}
