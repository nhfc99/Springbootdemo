package com.nhfc99.template.component.quartz.MyScheduler;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@Slf4j
@Component
public class CJJob implements Job {
//    @Autowired
//    CJService cjService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        JobDataMap map = jobExecutionContext.getMergedJobDataMap();
        Trigger trigger = jobExecutionContext.getTrigger();
        String triggerName = trigger.getKey().getName();
        log.info("开始定时任务：{}，开始时间{}", triggerName, new Date());

        //Todo trigger要做什么任务
        DateTime dateTime = new DateTime();                 //今天
        DateTime yesterday = dateTime.minusDays(1);         //昨天

//        //检查一下前天的数据是否已采集成功
//        cjService.cjBeforeYesterday(yesterday);
//
//        //采集昨天的数据
//        cjService.cjLoginAndGetData(dateTime);

        log.info("结束定时任务：{}，结束时间{}", triggerName, new Date());
    }
}
