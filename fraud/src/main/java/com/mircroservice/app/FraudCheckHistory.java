package com.mircroservice.app;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FraudCheckHistory {

  @Id
  @SequenceGenerator(name = "fraud_id_seq", sequenceName = "fraud_id_seq")
  @GeneratedValue(generator = "fraud_id_seq")
  private Integer id;
  private Integer customerId;
  private boolean isFraud;
  private LocalDateTime createAt;

}
