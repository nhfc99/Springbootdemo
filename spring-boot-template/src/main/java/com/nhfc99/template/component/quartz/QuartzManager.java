package com.nhfc99.template.component.quartz;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

//@Component
@Transactional(rollbackFor = Exception.class)
public class QuartzManager {

    private static final Logger logger = LoggerFactory.getLogger(QuartzManager.class);

    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;

    //注入DefaultJob类
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(DefaultJob.class)
                .withIdentity("defaultJob")
                .storeDurably()
                .build();
    }

    /**
     * 添加SimpleTrigger
     */
    public void addSimppleTrigger(String triggerName, Date startDate, Long repeatInterval, Long repeatCount) throws Exception {
        try {
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, Scheduler.DEFAULT_GROUP);
            //triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(simpleSchedule()
                    .withIntervalInSeconds(repeatInterval.intValue())
                    .withRepeatCount(repeatCount.intValue()))
                    .startAt(startDate);
            triggerBuilder.forJob(jobDetail());
            // 创建Trigger对象
            SimpleTrigger trigger = (SimpleTrigger) triggerBuilder.build();
            scheduler.addJob(jobDetail(), true);
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(trigger);
        } catch (Exception e) {
            logger.error("添加Simple定时器失败!", e);
            throw new Exception("添加Simple定时器失败!");
        }
        logger.info("添加Simple定时器成功!");
    }

    /**
     * 添加CronTrigger
     */
    public void addCronTrigger(String triggerName, String cron) throws Exception {
        try {
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, Scheduler.DEFAULT_GROUP);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            triggerBuilder.forJob(jobDetail());
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            scheduler.addJob(jobDetail(), true);
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(trigger);
        } catch (Exception e) {
            logger.error("添加cron定时器失败!", e);
            throw new Exception("添加cron定时器失败!", e);
        }
        logger.info("添加cron定时器成功!");
    }

    /**
     * 暂停Trigger
     */
    public void pauseTrigger(String triggerName) throws Exception {
        try {
            logger.info("休眠定时器:" + triggerName);
            TriggerKey triggerKey = new TriggerKey(triggerName, Scheduler.DEFAULT_GROUP);
            //停止触发器
            scheduler.pauseTrigger(triggerKey);
        } catch (Exception e) {
            logger.info("休眠定时器失败!");
            throw new Exception("休眠定时器失败!", e);
        }
        logger.info("休眠定时器成功!");
    }

    /**
     * 恢复Trigger
     *
     * @param triggerName
     * @throws Exception
     */
    public void resumeTrigger(String triggerName) throws Exception {
        try {
            logger.info("激活定时器:" + triggerName);
            TriggerKey triggerKey = new TriggerKey(triggerName, Scheduler.DEFAULT_GROUP);
            //重启触发器
            scheduler.resumeTrigger(triggerKey);
        } catch (Exception e) {
            logger.info("激活定时器失败!");
            throw new Exception("激活定时器失败!", e);
        }
        logger.info("激活定时器成功!");
    }

    /**
     * 删除Trigger
     */
    public boolean removeTrigger(String triggerName) throws Exception {
        try {
            logger.info("移除定时器:" + triggerName);
            TriggerKey triggerKey = new TriggerKey(triggerName, Scheduler.DEFAULT_GROUP);
            //停止触发器
            scheduler.pauseTrigger(triggerKey);
            //移除触发器
            return scheduler.unscheduleJob(triggerKey);
        } catch (Exception e) {
            logger.error("移除定时器失败!", e);
            throw new Exception("移除定时器失败!", e);
        }
    }

    /**
     * 测试定时器调度
     */
    public void testScheduler1() throws SchedulerException {
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("testScheduler1", "group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .forJob(jobDetail())
                .build();
        scheduler.addJob(jobDetail(), true);
        scheduler.scheduleJob(trigger);
    }

    public void stopSchedule1() throws SchedulerException {
        List<String> groupNames = scheduler.getJobGroupNames();
        for (int i = 0; i < groupNames.size(); i++) {
            Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupNames.get(i)));

            for (JobKey jobKey : jobKeys) {                                                 //删除从数据库中注册的所有JOB
                scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
                scheduler.deleteJob(jobKey);
            }
        }
    }

//    /**
//     * 重新启动所有的job
//     */
//    private void reStartAllJobs() throws SchedulerException {
//        synchronized (logger) {                                                         //只允许一个线程进入操作
//            Scheduler scheduler = schedulerFactoryBean.getScheduler();
//            Set<JobKey> set = scheduler.getJobKeys(GroupMatcher.anyGroup());
//            scheduler.pauseJobs(GroupMatcher.anyGroup());                               //暂停所有JOB
//            for (JobKey jobKey : set) {                                                 //删除从数据库中注册的所有JOB
//                scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
//                scheduler.deleteJob(jobKey);
//            }
//            for (JobEntity job : jobService.loadJobs()) {                               //从数据库中注册的所有JOB
//                logger.info("Job register name : {} , group : {} , cron : {}", job.getName(), job.getJobGroup(), job.getCron());
//                JobDataMap map = jobService.getJobDataMap(job);
//                JobKey jobKey = jobService.getJobKey(job);
//                JobDetail jobDetail = jobService.getJobDetail(jobKey, job.getDescription(), map);
//                if (job.getStatus().equals("OPEN")) scheduler.scheduleJob(jobDetail, jobService.getTrigger(job));
//                else
//                    logger.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
//            }
//        }
//    }
//
//    //修改某个Job执行的Cron
//    @PostMapping("/modifyJob")
//    public String modifyJob(@RequestBody @Validated ModifyCronDTO dto) {
//        if (!CronExpression.isValidExpression(dto.getCron())) return "cron is invalid !";
//        synchronized (logger) {
//            JobEntity job = jobService.getJobEntityById(dto.getId());
//            if (job.getStatus().equals("OPEN")) {
//                try {
//                    JobKey jobKey = jobService.getJobKey(job);
//                    TriggerKey triggerKey = new TriggerKey(jobKey.getName(), jobKey.getGroup());
//                    Scheduler scheduler = schedulerFactoryBean.getScheduler();
//                    CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
//                    String oldCron = cronTrigger.getCronExpression();
//                    if (!oldCron.equalsIgnoreCase(dto.getCron())) {
//                        job.setCron(dto.getCron());
//                        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(dto.getCron());
//                        CronTrigger trigger = TriggerBuilder.newTrigger()
//                                .withIdentity(jobKey.getName(), jobKey.getGroup())
//                                .withSchedule(cronScheduleBuilder)
//                                .usingJobData(jobService.getJobDataMap(job))
//                                .build();
//                        scheduler.rescheduleJob(triggerKey, trigger);
//                        repository.save(job);
//                    }
//                } catch (Exception e) {
//                    logger.error("printStackTrace", e);
//                }
//            } else {
//                logger.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
//                return "modify failure , because the job is closed";
//            }
//        }
//        return "modify success";
//    }
//
//    //获取JobDataMap.(Job参数对象)
//    public JobDataMap getJobDataMap(JobEntity job) {
//        JobDataMap map = new JobDataMap();
//        map.put("name", job.getName());
//        map.put("jobGroup", job.getJobGroup());
//        map.put("cronExpression", job.getCron());
//        map.put("parameter", job.getParameter());
//        map.put("jobDescription", job.getDescription());
//        map.put("vmParam", job.getVmParam());
//        map.put("jarPath", job.getJarPath());
//        map.put("status", job.getStatus());
//        return map;
//    }
//
//    //获取JobDetail,JobDetail是任务的定义,而Job是任务的执行逻辑,JobDetail里会引用一个Job Class来定义
//    public JobDetail getJobDetail(JobKey jobKey, String description, JobDataMap map) {
//        return JobBuilder.newJob(DynamicJob.class)
//                .withIdentity(jobKey)
//                .withDescription(description)
//                .setJobData(map)
//                .storeDurably()
//                .build();
//    }
//
//    //获取Trigger (Job的触发器,执行规则)
//    public Trigger getTrigger(JobEntity job) {
//        return TriggerBuilder.newTrigger()
//                .withIdentity(job.getName(), job.getJobGroup())
//                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCron()))
//                .build();
//    }
//
//    //获取JobKey,包含Name和Group
//    public JobKey getJobKey(JobEntity job) {
//        return JobKey.jobKey(job.getName(), job.getJobGroup());
//    }
}