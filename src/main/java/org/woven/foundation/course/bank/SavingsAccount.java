package org.woven.foundation.course.bank;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public void applyInterest() {
        double interest = interestRate * interestRate;
        deposit(interest);
    }
    public SavingsAccount(final String accountNumber, final double balance,
                          final AccountType accountType, final String accountName) {
        super(accountNumber, balance, accountType, accountName);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345",0,AccountType.SAVINGS,"ICICI Bank");
        try {
            account.deposit(10);
            account.withdraw(10);
            account.deposit(22);
            account.deposit(-300);
            account.withdraw(220);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(account);
    }
}
