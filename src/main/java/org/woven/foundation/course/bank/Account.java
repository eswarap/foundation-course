package org.woven.foundation.course.bank;

import lombok.SneakyThrows;

public interface Account {
    void deposit(double amount);

    @SneakyThrows
    void withdraw(double amount);

    double getBalance();
}
