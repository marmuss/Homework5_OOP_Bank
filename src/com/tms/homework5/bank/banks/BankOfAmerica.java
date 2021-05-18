package com.tms.homework5.bank.banks;

import com.tms.homework5.account.Account;
import com.tms.homework5.bank.Bank;
import com.tms.homework5.bank.IBank;
import com.tms.homework5.client.Client;
import com.tms.homework5.constants.Constants;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Класс  Bank of America наследник класса Bank
 */
public class BankOfAmerica extends Bank implements IBank {

    int stateNumber;
    String stateName;

    public BankOfAmerica(String bankName, String bankLocation, int bankCode, String nationalCurrency, LocalDate bankLicenseExpDate,
                         double minAccountAmount, Client[] bankClients, int stateNumber, String stateName) {
        super(bankName, bankLocation, bankCode, nationalCurrency, bankLicenseExpDate, minAccountAmount, bankClients);
        this.stateNumber = stateNumber;
        this.stateName = stateName;
    }

    @Override
    public void addBankAccount(Account account, Client client) {
        System.out.println("Открытие счета в Bank of America");
        for (Client item : bankClients){
            if (item != null){
                if (item.equals(client)){
                    System.out.println("Открываем счет для "  + item.firstName);
                    item.openAccount(account);
                    break;
                }
            }


            }
    }

    @Override
    public void changeBankAccount(Account account, Client client, double newAccountAmount) {
        System.out.println("Изменить счет в Bank of America на " + newAccountAmount + Constants.BANK_OF_AMERICA_NATIONAL_CURRENCY );
        client.changeAccount(account, newAccountAmount);
    }

    @Override
    public void closeBankAccount(Account account, Client client) {
        System.out.println("Закрытие счета в Bank of America");
        client.deleteAccount(account);
    }

    @Override
    public void autoCloseAccount(Account[] clientAccounts) {
        System.out.println("Удаление просроченных счетов в Bank of America");
        deleteClientExpAccounts(clientAccounts);
    }

    @Override
    public String toString() {
        return "BankOfAmerica{" +
                "bankName='" + bankName + '\'' +
                ", bankLocation='" + bankLocation + '\'' +
                ", bankCode=" + bankCode +
                ", nationalCurrency='" + nationalCurrency + '\'' +
                ", bankLicenseExpDate=" + bankLicenseExpDate +
                ", minAccountAmount=" + minAccountAmount +
                ", bankClients=" + Arrays.toString(bankClients) +
                ", stateNumber=" + stateNumber +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}

