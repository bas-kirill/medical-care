package ru.tfs.spring.web.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tfs.spring.web.service.VaccinationService;

@Slf4j
@Component
@DisallowConcurrentExecution
public class VaccinationSendJob implements Job {

    @Autowired
    private VaccinationService vaccinationService;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Send to kafka");
        vaccinationService.sendRecordToKafka();
    }
}
