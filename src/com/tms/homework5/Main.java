package com.tms.homework5;
/**
 * Запуск
 */

import com.tms.homework5.account.Account;
import com.tms.homework5.bank.Bank;
import com.tms.homework5.bank.banks.BankOfAmerica;
import com.tms.homework5.bank.banks.ChinaBank;
import com.tms.homework5.bank.banks.DeutscheBank;
import com.tms.homework5.client.Client;
import com.tms.homework5.constants.Constants;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account[] clientAccounts = new Account[3];
        Client client = new Client("Muss", "Maria", LocalDate.of(1992, 3, 5),
                "MP5679974", "female", clientAccounts);
        Client client1 = new Client("Johnson", "John", LocalDate.of(1976, 12, 7),
                "456789998", "male", clientAccounts);

        Account account = new Account("23467686768", 300.00,
                LocalDate.of(2022, 6, 12));
        Account account1 = new Account("234676811", 200.89,
                LocalDate.of(2020, 6, 12));

        Client[] clients;
        Bank bank = chooseBank(1);

        bank.addClient(client);
        System.out.println();
        bank.addBankAccount(account, client);
        System.out.println();
        bank.changeBankAccount(account, client, 576.90);
        System.out.println();
        bank.closeBankAccount(account, client);

        System.out.println();
        System.out.println();
        bank.addClient(client1);
        bank.addBankAccount(account1, client1);

        System.out.println();
        bank.autoCloseAccount(clientAccounts);


















    }

   private static Bank chooseBank(int number) {
        Bank bank = null;

        switch (number) {
            case 1: {
                Client[] bankClients = new Client[4];
                bank = new BankOfAmerica("Bank of America", Constants.BANK_OF_AMERICA_LOCATION, Constants.BANK_OF_AMERICA_CODE,
                        Constants.BANK_OF_AMERICA_NATIONAL_CURRENCY, LocalDate.of(2023, 3, 12),
                        200.00, bankClients, 25, "Massachusetts");
                break;
            }

            case 2: {
                Client[] bankClients = new Client[10];
                bank = new ChinaBank("China bank", Constants.CHINA_BANK_LOCATION, Constants.CHINA_BANK_CODE,
                        Constants.CHINA_BANK_NATIONAL_CURRENCY, LocalDate.of(2025, 8, 5), 50, bankClients,
                        "Hubei");
                break;
            }

            case 3: {
                Client[] bankClients = new Client[6];
                bank = new DeutscheBank("Deutsche Bank", Constants.DEUTSCHE_BANK_LOCATION, Constants.DEUTSCHE_BANK_CODE,
                        Constants.DEUTSCHE_BANK_NATIONAL_CURRENCY,
                        LocalDate.of(2022, 9, 24), 125.00, bankClients,
                        "Land Berlin");
                break;
            }
            default:
                System.out.println("Такого банка в системе нет");
                break;
        }

        return bank;
    }

}




