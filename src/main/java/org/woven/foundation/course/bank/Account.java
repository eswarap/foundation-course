package org.woven.foundation.course.bank;

import lombok.*;

public interface Account {
    void deposit(double amount);

    @SneakyThrows
    void withdraw(double amount);

    double getBalance();
}
