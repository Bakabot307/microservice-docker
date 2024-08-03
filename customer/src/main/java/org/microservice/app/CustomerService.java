package org.microservice.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;
  private final FeignClientHttp feignClientHttp;

  public void register(CustomerRegistrationRequest customerRequest) {
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email())
        .build();
    customerRepository.saveAndFlush(customer);
    // check if customer is a fraud by using http request to fraud service
//    FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8081/ap1/v1/fraud-check/{customerId}",
//        FraudResponse.class, customer.getId());

    // check if customer is a fraud by using feign client
    FraudResponse fraudResponse = feignClientHttp.isFraud(customer.getId());
    if (fraudResponse.isFraud()) {
      throw new IllegalStateException("Customer is a fraud");
    }
  }
}
