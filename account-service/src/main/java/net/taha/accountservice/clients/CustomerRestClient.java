package net.taha.accountservice.clients;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Builder;
import net.taha.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder().firstName("Default").lastName("Default").email("Default").build();
    }
    default List<Customer> getAllCustomers(Exception e){
        return List.of(Customer.builder().firstName("Default").lastName("Default").email("Default").build());
    }
}
