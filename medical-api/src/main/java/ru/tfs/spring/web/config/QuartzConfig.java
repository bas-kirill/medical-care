package ru.tfs.spring.web.config;

import org.apache.commons.lang.ArrayUtils;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import ru.tfs.spring.web.scheduler.VaccinationSendJob;

import javax.sql.DataSource;

@Configuration
public class QuartzConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(VaccinationSendJob.class);
        jobDetailFactory.setDescription("Send record to kafka...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public SimpleTriggerFactoryBean trigger(JobDetail job) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(job);
        trigger.setRepeatInterval(5000);
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return trigger;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean scheduler(DataSource dataSource, Trigger... triggers) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

        schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));

        schedulerFactory.setOverwriteExistingJobs(true);
        schedulerFactory.setAutoStartup(true);
        schedulerFactory.setDataSource(dataSource);
        schedulerFactory.setJobFactory(springBeanJobFactory());
        schedulerFactory.setWaitForJobsToCompleteOnShutdown(true);

        if (ArrayUtils.isNotEmpty(triggers)) {
            schedulerFactory.setTriggers(triggers);
        }


        return schedulerFactory;
    }
}
