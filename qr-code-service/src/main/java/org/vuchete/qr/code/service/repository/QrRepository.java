package org.vuchete.qr.code.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.vuchete.qr.code.service.model.QRCode;

public interface QrRepository extends CrudRepository<QRCode, Long> {
}
