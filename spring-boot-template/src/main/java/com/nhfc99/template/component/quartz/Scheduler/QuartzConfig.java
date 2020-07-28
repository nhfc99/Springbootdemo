package com.nhfc99.template.component.quartz.Scheduler;

import com.nhfc99.template.component.quartz.MyScheduler.CJJob;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Configuration
public class QuartzConfig {
//    @Autowired
//    private MyJobFactory myJobFactory;
//
//    @Autowired
//    private QuartzManager quartzManager;
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setJobFactory(myJobFactory);
//        System.out.println("myJobFactory:" + myJobFactory);
//        return schedulerFactoryBean;
//    }
//
//    @Bean
//    public Scheduler scheduler() {
//        return schedulerFactoryBean().getScheduler();
//    }
//
//    @Bean
//    public void schedulerStart() {
//        quartzManager.addJob("job", "jobgroupname", "triggername",
//                "triggergroupname", CJJob.class, "0 15 0 * * ?");
////        quartzManager.addJob("job", "jobgroupname", "triggername",
////                "triggergroupname", CJJob.class, "0 21 15 * * ? ");
////        quartzManager.addJob("job", "jobgroupname", "triggername",
////                "triggergroupname", CJJob.class, "0/5 * * * * ? *");
//        quartzManager.startJobs();
//    }
}