package org.microservice.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud-check", url = "http://localhost:8081/api/v1")
public interface FeignClientHttp {
@GetMapping(value = "/fraud-check/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  FraudResponse isFraud(@PathVariable("customerId") Integer customerId);
}
