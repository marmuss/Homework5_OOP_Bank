package com.tms.homework5.bank;

import com.tms.homework5.account.Account;
import com.tms.homework5.client.Client;

/**
 * Интерфейс
 * Каждый банк должен добавлять, изменять и удалять счета
 */

public interface IBank {

    void addBankAccount(Account account, Client client);

    void closeBankAccount(Account account, Client client);

    void changeBankAccount(Account account, Client client, double newAccountAmount);

    void autoCloseAccount(Account[] clientAccounts);

}
