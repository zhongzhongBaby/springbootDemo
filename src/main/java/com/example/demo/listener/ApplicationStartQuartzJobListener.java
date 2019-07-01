package com.example.demo.listener;
import com.example.demo.quartz.MyQuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;



@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    private MyQuartzScheduler myQuartzScheduler;

    /**
     * 初始注入scheduler
     * @return
     * @throws SchedulerException
     */

    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       /* try {
            myQuartzScheduler.startJob();
            System.out.println("任务已经启动...");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/
    }
}
