package net.taha.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.taha.accountservice.enums.AccountType;
import net.taha.accountservice.model.Customer;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING )
    private AccountType accountType;
    private Long customerId;
    @Transient
    private Customer customer;

}
