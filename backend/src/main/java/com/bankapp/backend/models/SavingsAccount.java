package com.bankapp.backend.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("SAV")
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccount extends Account {
    private double interestRate;
}
