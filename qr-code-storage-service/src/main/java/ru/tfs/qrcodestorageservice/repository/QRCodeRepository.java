package ru.tfs.qrcodestorageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfs.qrcodestorageservice.model.entity.QRCode;

import java.util.Optional;

public interface QRCodeRepository extends JpaRepository<QRCode, Long> {

    Optional<QRCode> findByHash(String hash);

    QRCode findFirstByPassportOrderByExpiredDateDesc(String passport);
}
