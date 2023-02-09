package ru.tfs.qrcodestorageservice.mapper;

import org.mapstruct.Mapper;
import ru.tfs.qrcodestorageservice.model.dto.QRCodeDto;
import ru.tfs.qrcodestorageservice.model.entity.QRCode;

@Mapper
public interface QRCodeMapper {

    QRCodeDto toDto(QRCode qrCode);
}
