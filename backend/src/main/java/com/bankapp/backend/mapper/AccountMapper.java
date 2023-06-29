package com.bankapp.backend.mapper;

import com.bankapp.backend.dto.CustomerDTO;
import com.bankapp.backend.dto.SavingsAccountDTO;
import com.bankapp.backend.models.Customer;
import com.bankapp.backend.models.SavingsAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    public SavingsAccountDTO fromSavingsAccount(SavingsAccount savingsAccount){
        SavingsAccountDTO savingsAccountDTO = new SavingsAccountDTO();
        BeanUtils.copyProperties(savingsAccount, savingsAccountDTO);
        savingsAccountDTO.setCustomerDTO(fromCustomer(savingsAccount.getCustomer()));
        savingsAccountDTO.setType(savingsAccount.getClass().getSimpleName());
        return savingsAccountDTO;
    }
}
