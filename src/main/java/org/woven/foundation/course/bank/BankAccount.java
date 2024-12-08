package org.woven.foundation.course.bank;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

@Getter
@ToString
public  class BankAccount implements Account {
    private final String accountNumber;
    private final AccountType accountType;
    private final String accountName;
    private double balance;

    public BankAccount(final String accountNumber, final double balance,
                       final AccountType accountType, final String accountName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.accountName = accountName;
    }

    @Override
    public void deposit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit amount must be greater than 0");
        }
        balance += amount;
    }
    @Override
    @SneakyThrows
    public void withdraw(final double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
        else {
            throw new IllegalArgumentException("withdrawal amount must be lesser or equal to balance");
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
}
