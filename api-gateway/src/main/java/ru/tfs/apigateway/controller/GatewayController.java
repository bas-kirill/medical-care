package ru.tfs.apigateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.tfs.apigateway.model.InfoDto;
import ru.tfs.apigateway.service.GatewayService;

@RestController
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;

    @GetMapping("/api/v1/info/{passport}")
    public Mono<InfoDto> getInfByPassport(@PathVariable String passport) {
        return gatewayService.getInfoByPassport(passport);
    }

    @RequestMapping("/error")
    public Mono<String> fallback() {
        return Mono.just("Error");
    }
}
