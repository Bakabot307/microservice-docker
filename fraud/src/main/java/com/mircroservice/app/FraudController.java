package com.mircroservice.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

  private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
  public FraudResponse isFraud(@PathVariable("customerId") Integer customerId) {
    boolean isFraudCustomer = fraudService.isFraud(customerId);
    log.info("Customer with id: {} is a fraud: {}", customerId, isFraudCustomer);
    return new FraudResponse(isFraudCustomer);
  }
}
