package com.tms.homework5.account;

import java.time.LocalDate;
import java.util.Objects;

/**
 *   Класс Account
 *   checkAccountNumber -  проверяет номер счета на наличие запрещенных символов
 */

public class Account {

    public String accountNumber;
    public double accountAmount;
    public LocalDate accountExpDate;

    public Account(String accountNumber, double accountAmount, LocalDate accountExpDate) {
        if (checkAccountNumber(accountNumber)){
            this.accountNumber = accountNumber;
            this.accountAmount = accountAmount;
            this.accountExpDate = accountExpDate;
        } else {
            System.out.println("Неверный номер счета");
        }

    }

    boolean checkAccountNumber(String accountNumber){
        return accountNumber.matches("[0-9a-zA-Z]+");
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountAmount=" + accountAmount +
                ", accountExpDate=" + accountExpDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        if (accountNumber != account.accountNumber) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
