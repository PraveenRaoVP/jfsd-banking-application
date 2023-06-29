package com.bankapp.backend.dto;

import com.bankapp.backend.models.enums.AccountStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SavingsAccountDTO extends AccountDTO{
    private String id;
    private double balance;
    private double interestRate;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;


}
