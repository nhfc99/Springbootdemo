package com.nhfc99.template.publish;

import com.nhfc99.template.component.quartz.QuartzManager;
import org.quartz.SchedulerException;
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

    @Autowired
    QuartzManager quartzManager;

    @GetMapping("/list")
    @ResponseBody
    public String initView() {
        return "list成功了";
    }

    @GetMapping("/startscheduler")
    @ResponseBody
    public Object startScheduler() throws SchedulerException {
        quartzManager.testScheduler1();
        return "开启了";
    }

    @GetMapping("/stopscheduler")
    @ResponseBody
    public Object stopSchedule() throws SchedulerException {
        quartzManager.stopSchedule1();
        return "全部关闭了";
    }
}