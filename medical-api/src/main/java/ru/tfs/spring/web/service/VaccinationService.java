package ru.tfs.spring.web.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.multipart.MultipartFile;
import ru.tfs.spring.web.client.PersonClient;
import ru.tfs.spring.web.mapper.VaccinationMapper;
import ru.tfs.spring.web.model.csv.VaccinationCsv;
import ru.tfs.spring.web.model.dto.VaccinationDto;
import ru.tfs.spring.web.model.entity.Vaccination;
import ru.tfs.spring.web.parser.VaccinationParser;
import ru.tfs.spring.web.repository.VaccinationRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaccinationService {
    private static final String VERIFY = "verify";
    private static final String TOPIC_NAME = "vaccination";

    private final KafkaTemplate<String, VaccinationDto> kafkaTemplate;
    private final VaccinationRepository vaccinationRepository;
    private final PersonClient personClient;
    private final VaccinationParser vaccinationParserCsv;
    private final VaccinationMapper vaccinationMapper;

    public void processFile(MultipartFile file) {
        List<VaccinationCsv> vaccinationCsvs = vaccinationParserCsv.parse(file);
        for (VaccinationCsv vaccinationCsv : vaccinationCsvs) {
            String fullName = vaccinationCsv.getFullName();
            String passportNumber = vaccinationCsv.getPassportNumber();
            if (!isVerify(fullName, passportNumber)) {
                log.warn("Person {} with passport {} not verified!", fullName, passportNumber);
                continue;
            }
            Vaccination vaccination = vaccinationMapper.toEntity(vaccinationCsv);
            try {
                vaccinationRepository.save(vaccination);
            } catch (Exception e) {
                log.error("Save from file error: {}", e.getMessage());
            }
        }
    }

    @Transactional(readOnly = true)
    public VaccinationDto getVaccination(String document) {
        var vaccination = vaccinationRepository.findFirstByPassportNumber(document);
        return vaccination.map(vaccinationMapper::toDto).orElse(null);
    }

    @CircuitBreaker(name = VERIFY, fallbackMethod = "fallback")
    @Retry(name = VERIFY)
    public boolean isVerify(String fullName, String passportNumber) {
        return personClient.verify(fullName, passportNumber);
    }

    public void sendRecordToKafka() {
        vaccinationRepository.findFirstByIsSent(false).ifPresent(vaccination -> {
            VaccinationDto vaccinationDto = vaccinationMapper.toDto(vaccination);
            ListenableFuture<SendResult<String, VaccinationDto>> resultListenableFuture = kafkaTemplate.send(TOPIC_NAME, vaccinationDto);
            resultListenableFuture.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("Kafka failure: {}", ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, VaccinationDto> result) {
                    vaccination.setSent(true);
                    vaccinationRepository.save(vaccination);
                    log.info("Kafka success: {}", result.getProducerRecord().value());
                }
            });
        });
    }

    private boolean fallback(Exception ex) {
        log.error("Fallback after: {}", ex.getMessage());
        return false;
    }
}
