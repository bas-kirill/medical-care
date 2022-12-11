package org.vuchete.medical.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("person-service")
public interface PersonClient {
  @GetMapping("/api/v1/person-service/verify")
  boolean verify(String fullName, String passport);
}
