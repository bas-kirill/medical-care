package ru.tfs.qrcodestorageservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tfs.qrcodestorageservice.model.dto.QRCodeDto;
import ru.tfs.qrcodestorageservice.service.QRCodeService;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeService qrCodeService;

    @GetMapping("/{passport}")
    public QRCodeDto getQr(@PathVariable String passport) {
        return qrCodeService.getQrCode(passport);
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String code) {
        return qrCodeService.check(code);
    }

}
