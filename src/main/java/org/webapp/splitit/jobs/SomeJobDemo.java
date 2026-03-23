package org.webapp.splitit.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.webapp.splitit.services.base.UserService;

@Component
public class SomeJobDemo implements Job {
    @Autowired
    private UserService userService;

    @Override
    @Scheduled(cron = "0/1 * * * * ?")
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("aaaaaaa");
    }
}
