package com.tms.homework5.bank.banks;

import com.tms.homework5.account.Account;
import com.tms.homework5.bank.Bank;
import com.tms.homework5.bank.IBank;
import com.tms.homework5.client.Client;
import com.tms.homework5.constants.Constants;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Класс  DeutscheBank наследник класса Bank
 */

public class DeutscheBank extends Bank implements IBank {

    String federalStateName;

    public DeutscheBank(String bankName, String bankLocation, int bankCode, String nationalCurrency, LocalDate bankLicenseExpDate,
                        double minAccountAmount, Client[] bankClients, String federalStateName) {
        super(bankName, bankLocation, bankCode, nationalCurrency, bankLicenseExpDate, minAccountAmount, bankClients);
        this.federalStateName = federalStateName;
    }

    @Override
    public void addBankAccount(Account account, Client client) {
        System.out.println("Открытие счета в Deutsche Bank");
        if (account.accountAmount >= this.minAccountAmount){
            client.openAccount(account);
        } else {
            System.out.println("Счет открыть не удалось. Минимальная сумма для открытия счета " + minAccountAmount);
        }
    }


    @Override
    public void closeBankAccount(Account account, Client client) {
        System.out.println("Закрытие счета в Deutsche Bank");
        client.deleteAccount(account);
    }

    @Override
    public void changeBankAccount(Account account, Client client, double newAccountAmount) {
        System.out.println("Изменить счет в China Bank на " + newAccountAmount + Constants.DEUTSCHE_BANK_NATIONAL_CURRENCY );
        client.changeAccount(account, newAccountAmount);
    }

    @Override
    public void autoCloseAccount(Account[] clientAccounts) {
        System.out.println("Удаление просроченных счетов в Deutsche Bank");
        deleteClientExpAccounts(clientAccounts);
    }


    @Override
    public String toString() {
        return "DeutscheBank{" +
                "bankName='" + bankName + '\'' +
                ", bankLocation='" + bankLocation + '\'' +
                ", bankCode=" + bankCode +
                ", nationalCurrency='" + nationalCurrency + '\'' +
                ", bankLicenseExpDate=" + bankLicenseExpDate +
                ", minAccountAmount=" + minAccountAmount +
                ", bankClients=" + Arrays.toString(bankClients) +
                ", federalStateName='" + federalStateName + '\'' +
                '}';
    }
}
