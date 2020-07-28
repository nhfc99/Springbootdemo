package com.nhfc99.template.component.quartz.MyScheduler;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzConfig {

    @Autowired
    private MyJobFactory myJobFactory;

    //job配置
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(CJJob.class);
        return jobDetailFactoryBean;
    }

    @Bean
    //触发器配置
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        cronTriggerFactoryBean.setCronExpression("0/5 * * * * ? *");
        return cronTriggerFactoryBean;
    }

    //中心配置
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //schedulerFactoryBean.setDataSource(datasource());
        //自定义job工厂，交给spring管理
        schedulerFactoryBean.setJobFactory(myJobFactory);
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean().getObject()); //如果使用数据库的配置，就不需要配置job与trigger
        return schedulerFactoryBean;
    }

    @Bean(name = "Scheduler")  //获得可以操作定时任务的对象
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}