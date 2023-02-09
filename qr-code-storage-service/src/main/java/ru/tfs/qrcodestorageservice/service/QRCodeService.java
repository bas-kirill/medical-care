package ru.tfs.qrcodestorageservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tfs.qrcodestorageservice.mapper.QRCodeMapper;
import ru.tfs.qrcodestorageservice.model.dto.QRCodeDto;
import ru.tfs.qrcodestorageservice.model.entity.QRCode;
import ru.tfs.qrcodestorageservice.repository.QRCodeRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QRCodeService {

    private final QRCodeRepository qrCodeRepository;
    private final QRCodeMapper qrCodeMapper;
    public QRCodeDto getQrCode(String passport) {
        QRCode qrCode = qrCodeRepository.findFirstByPassportOrderByExpiredDateDesc(passport);
        return qrCodeMapper.toDto(qrCode);
    }

    public boolean check(String code) {
        var qrCodeOptional = qrCodeRepository.findByHash(code);
        return qrCodeOptional.filter(qrCode -> !qrCode.getExpiredDate().isBefore(LocalDate.now())).isPresent();
    }
}
