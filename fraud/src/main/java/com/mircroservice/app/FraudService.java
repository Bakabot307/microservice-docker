package com.mircroservice.app;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudService {
  private  final FraudRepository fraudRepository;
  public boolean isFraud(Integer customerId) {
    fraudRepository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .isFraud(false)
        .createAt(LocalDateTime.now())
        .build());
    return false;
  }


}
