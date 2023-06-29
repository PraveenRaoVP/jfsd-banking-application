package com.bankapp.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CurrentAccountDTO extends AccountDTO{
    private String id;
    private double balance;
    private double interestRate;
    private double overdraft;
    private Date createdAt;
    private CustomerDTO customerDTO;
}
