package com.example.demo.controller;

import com.example.demo.quartz.MyQuartzScheduler;
import org.quartz.SchedulerException;
import org.quartz.core.QuartzScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 这里并没有采用restful风格 只是简单封装了一下api   通过接口调用控制定时任务
 *
 * @author yvan
 *
 */
//@RestController
@RequestMapping("/demo/quartz")
public class QuartzApiController {
    @Autowired
    private MyQuartzScheduler myQuartzScheduler;

    @RequestMapping("/start")
    public void startQuartzJob() {
        try {
            myQuartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = myQuartzScheduler.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    @RequestMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = myQuartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            myQuartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            myQuartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            myQuartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
