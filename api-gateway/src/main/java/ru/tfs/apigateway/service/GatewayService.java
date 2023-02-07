package ru.tfs.apigateway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tfs.apigateway.model.InfoDto;
import ru.tfs.apigateway.model.medical.VaccinationDto;
import ru.tfs.apigateway.model.person.PersonDto;
import ru.tfs.apigateway.model.qr.QRCodeDto;

@Service
@RequiredArgsConstructor
public class GatewayService {

    private final WebClient.Builder webClientBuilder;

    public Mono<InfoDto> getInfoByPassport(String passport) {
        Mono<PersonDto> personDtoMono = getFromService(passport, PersonDto.class);
        Mono<VaccinationDto> vaccinationDtoMono = getFromService(passport, VaccinationDto.class);
        Mono<QRCodeDto> qrCodeDtoMono = getFromService(passport, QRCodeDto.class);
        return Mono.zip(personDtoMono, vaccinationDtoMono, qrCodeDtoMono)
                .flatMap(data -> Mono.just(new InfoDto(data.getT1(), data.getT2(), data.getT3())));
    }

    private <T> Mono<T> getFromService(String passport, Class<T> tClass) {
        String uri = createUri(passport, tClass);
        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(tClass);
    }

    private String createUri(String passport, Class<?> tClass) {
        if (PersonDto.class.equals(tClass)) {
            return "lb://PERSON-SERVICE/person/passport/" + passport;
        } else if (VaccinationDto.class.equals(tClass)) {
            return "lb://MEDICAL-API/vaccination?document=" + passport;
        } else if (QRCodeDto.class.equals(tClass)) {
            return "lb://QR-CODE-STORAGE-SERVICE/qr/" + passport;
        }
        throw new RuntimeException("Create uri failure: " + tClass.getName() + " not equals required class");
    }
}
