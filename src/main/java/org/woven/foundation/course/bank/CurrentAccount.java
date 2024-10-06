package org.woven.foundation.course.bank;

public class CurrentAccount extends BankAccount{
    private double balance;
    private final double overDraftLimit;

    // Constructor for initializing the balance and overdraft limit
    public CurrentAccount(final String accountNumber, final double balance,
                          final AccountType accountType, final String accountName,
                          final double initialDeposit, final double overdraftLimit) {
        super(accountNumber, balance, accountType, accountName);
        this.balance = initialDeposit;
        this.overDraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        // Check if the balance plus overdraft limit is sufficient to cover the withdrawal
        if (balance + overDraftLimit >= amount) {
            balance -= amount;
        }
    }
}
