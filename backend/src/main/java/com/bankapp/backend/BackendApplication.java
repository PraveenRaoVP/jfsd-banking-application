package com.bankapp.backend;

import com.bankapp.backend.models.AccountOperation;
import com.bankapp.backend.models.CurrentAccount;
import com.bankapp.backend.models.Customer;
import com.bankapp.backend.models.SavingsAccount;
import com.bankapp.backend.models.enums.AccountStatus;
import com.bankapp.backend.models.enums.OperationType;
import com.bankapp.backend.repository.AccountOperationRepository;
import com.bankapp.backend.repository.AccountRepository;
import com.bankapp.backend.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							AccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository) {
		return args -> {
			Stream.of("Salman Khan", "Praveen", "Rahul Gandhi").forEach(name -> {
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(name + "@gmail.com");
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				CurrentAccount currentAccount = new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random() * 90000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.ACTIVE);
				currentAccount.setCustomer(customer);
				currentAccount.setOverDraft(9000);
				bankAccountRepository.save(currentAccount);

				SavingsAccount savingAccount = new SavingsAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random() * 90000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.ACTIVE);
				savingAccount.setCustomer(customer);
				savingAccount.setInterestRate(5.5);
				bankAccountRepository.save(savingAccount);

			});
			bankAccountRepository.findAll().forEach(bankAccount -> {
				AccountOperation accountOperation = new AccountOperation();
				accountOperation.setDateOfOperationPerformed(new Date());
				accountOperation.setAmount(Math.random() * 10000);
				accountOperation.setOperationType(Math.random()>0.5? OperationType.ADD :OperationType.WITHDRAW);
				accountOperation.setAccount(bankAccount);
				accountOperationRepository.save(accountOperation);
			});
		};
	}
}
