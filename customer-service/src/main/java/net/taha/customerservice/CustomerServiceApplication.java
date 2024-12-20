package net.taha.customerservice;

import net.taha.customerservice.config.GlobalConfig;
import net.taha.customerservice.entities.Customer;
import net.taha.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(
                     Customer.builder()
                            .firstName("Taha Souhail")
                            .lastName("manna")
                            .email("manatahasouhail@gmail.com")
                            .build(),
             Customer.builder()
                    .firstName("Rabie ")
                    .lastName("Aaouiqa")
                    .email("rabieesk@gmail.com")
                    .build(),
            Customer.builder()
                    .firstName("khalid")
                    .lastName("esca")
                    .email("khalidesca@gmail.com")
                    .build()
            );
            customerRepository.saveAll(customerList);
        };
    }

}
