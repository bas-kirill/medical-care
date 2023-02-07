package ru.tfs.spring.web.client;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("person-service")
public interface PersonClient {

    @GetMapping("/person/verify")
    boolean verify(@RequestParam @NonNull String name, @RequestParam @NonNull String passport);
}
