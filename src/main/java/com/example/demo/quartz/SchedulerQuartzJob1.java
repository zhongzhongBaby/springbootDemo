package com.example.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchedulerQuartzJob1 implements Job {
    private void before(){
        System.out.println("任务开始1执行");
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        // TODO 业务
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }

    private void after(){
        System.out.println("任务结束1执行");
    }

}

