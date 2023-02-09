package ru.tfs.qrcodestorageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.tfs.qrcodestorageservice.model.dto.VaccinationDto;
import ru.tfs.qrcodestorageservice.model.entity.QRCode;
import ru.tfs.qrcodestorageservice.repository.QRCodeRepository;

import java.time.LocalDate;


@Slf4j
@Component
@RequiredArgsConstructor
public class QRCodeProcessor {

    private static final String TOPIC_NAME = "vaccination";

    private final ObjectMapper objectMapper;
    private final QRCodeRepository qrCodeRepository;

    @KafkaListener(topics = TOPIC_NAME, groupId = "${kafka.group_id}", containerFactory = "kafkaListener")
    public void processMessage(@Payload VaccinationDto vaccinationDto) throws JsonProcessingException {
        log.info("Start process message: {}", vaccinationDto);
        String hash = DigestUtils.md5Hex(objectMapper.writeValueAsString(vaccinationDto));
        LocalDate expiredDate = vaccinationDto.getVaccinationDate().plusYears(1);
        QRCode qrCode = new QRCode(hash, vaccinationDto.getPassportNumber(), expiredDate);
        qrCodeRepository.save(qrCode);
    }
}
