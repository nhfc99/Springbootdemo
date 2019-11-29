package com.nhfc99.template.component.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(QuartzJobBean.class);

    @Override
    public void execute(JobExecutionContext executorContext) throws JobExecutionException {
        JobDataMap map = executorContext.getMergedJobDataMap();
        Trigger trigger = executorContext.getTrigger();
        String triggerName = trigger.getKey().getName();
        logger.info("开始定时任务：{}，开始时间{}", triggerName, new Date());
        //Todo trigger要做什么任务
        logger.info("结束定时任务：{}，结束时间{}", triggerName, new Date());
    }
}
