package org.vuchete.qr.code.service.service;

import org.springframework.stereotype.Service;
import org.vuchete.qr.code.service.dto.QRCodeDto;
import org.vuchete.qr.code.service.repository.QrRepository;

@Service
public class QrService {
  private QrRepository qrRepository;

  public QrService(QrRepository qrRepository) {
    this.qrRepository = qrRepository;
  }

  public QRCodeDto getQrByPassport(String passport) {
    return new QRCodeDto();
  }

  public boolean checkQrCode(String qrCode) {
    return true;
  }
}
