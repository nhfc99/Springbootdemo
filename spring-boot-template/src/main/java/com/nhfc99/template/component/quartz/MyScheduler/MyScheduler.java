package com.nhfc99.template.component.quartz.MyScheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import static org.quartz.CronScheduleBuilder.cronSchedule;

//@Configuration
public class MyScheduler {
    @Bean
    public void startMyScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //创建JobDetail实例，并与HelloWordlJob类绑定
        JobDetail jobDetail = JobBuilder.newJob(CJJob.class).withIdentity("job", "jobGroup")
                .build();
        //创建触发器Trigger实例(立即执行，每隔1S执行一次)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cjjob", "triggerGroup")
                .startNow()
                .withSchedule(cronSchedule("0/5 * * * * ? *"))    //每天10:15运行
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())    //每天10:15运行
                .build();
        //开始执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}

