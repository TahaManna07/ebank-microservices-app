package net.taha.customerservice.web;

import lombok.AllArgsConstructor;
import net.taha.customerservice.entities.Customer;
import net.taha.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @PostMapping()
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
    @GetMapping("/customers")
    public List<Customer> customerList(){
       return  customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

}
