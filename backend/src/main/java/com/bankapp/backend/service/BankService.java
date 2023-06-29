package com.bankapp.backend.service;

import com.bankapp.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private AccountRepository accountRepository;

}
