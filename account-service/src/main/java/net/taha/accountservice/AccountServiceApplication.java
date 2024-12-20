package net.taha.accountservice;

import net.taha.accountservice.clients.CustomerRestClient;
import net.taha.accountservice.entities.BankAccount;
import net.taha.accountservice.enums.AccountType;
import net.taha.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
     return args ->{
         customerRestClient.allCustomers().forEach(customer -> {
             BankAccount bankAccount = BankAccount.builder()
                     .accountId(UUID.randomUUID().toString())
                     .balance(Math.random()*10000)
                     .createAt(LocalDate.now())
                     .currency("MAD")
                     .accountType(AccountType.CURRENT_ACCOUNT)
                     .customerId(customer.getId())
                     .build();
             BankAccount bankAccount1 = BankAccount.builder()
                     .accountId(UUID.randomUUID().toString())
                     .balance(Math.random()*10000)
                     .createAt(LocalDate.now())
                     .currency("EUR")
                     .accountType(AccountType.SAVING_ACCOUNT)
                     .customerId(customer.getId())
                     .build();
             accountRepository.save(bankAccount);
             accountRepository.save(bankAccount1);
         });





     };
    }


}
