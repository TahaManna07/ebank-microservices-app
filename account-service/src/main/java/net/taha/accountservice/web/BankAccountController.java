package net.taha.accountservice.web;

import lombok.AllArgsConstructor;
import net.taha.accountservice.clients.CustomerRestClient;
import net.taha.accountservice.entities.BankAccount;
import net.taha.accountservice.model.Customer;
import net.taha.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id){
        BankAccount bankAccount =  bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }



}
