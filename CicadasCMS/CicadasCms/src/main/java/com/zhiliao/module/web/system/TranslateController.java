package com.zhiliao.module.web.system;

import com.zhiliao.module.web.system.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/system/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping
    public String translate(){
        return "system/translate";
    }


    @PostMapping
    @ResponseBody
    public String translate(@RequestParam("text") String text){
        return translateService.translateToString(text);
    }

}
