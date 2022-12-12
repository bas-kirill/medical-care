package org.vuchete.qr.code.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vuchete.qr.code.service.dto.QRCodeDto;
import org.vuchete.qr.code.service.service.QrService;

@RestController
@RequestMapping("/api/v1/qr/")
public class QrCodeController {

  private QrService qrService;

  public QrCodeController(QrService qrService) {
    this.qrService = qrService;
  }

  @GetMapping()
  public QRCodeDto v1GetLastQRGet(@PathVariable String passport) {
    return qrService.getQrByPassport(passport);
  }

  @GetMapping("/check")
  public boolean v1CheckQRCodeGet(@RequestParam String qrCode) {
    return qrService.checkQrCode(qrCode);
  }
}
