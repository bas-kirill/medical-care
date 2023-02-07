package ru.tfs.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tfs.apigateway.model.medical.VaccinationDto;
import ru.tfs.apigateway.model.person.PersonDto;
import ru.tfs.apigateway.model.qr.QRCodeDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {

    private PersonDto person;
    private VaccinationDto vaccination;
    private QRCodeDto qrCode;

}
