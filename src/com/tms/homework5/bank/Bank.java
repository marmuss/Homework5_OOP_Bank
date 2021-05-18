package com.tms.homework5.bank;

import com.tms.homework5.account.Account;
import com.tms.homework5.client.Client;

import java.time.LocalDate;

/**
 *  Абстрактный класс Банк
 *  addClient - добавляет нового клиента в массив клиентов
 *  deleteClientExpAccounts - удаляет просроченные счета
 */
public abstract class Bank implements IBank {

    protected String bankName;
    protected String bankLocation;
    protected int bankCode;
    protected String nationalCurrency;
    protected LocalDate bankLicenseExpDate;
    protected double minAccountAmount;
    protected Client[] bankClients;

    public Bank(String bankName, String bankLocation, int bankCode, String nationalCurrency, LocalDate bankLicenseExpDate,
                double minAccountAmount, Client[] bankClients) {
        this.bankName = bankName;
        this.bankLocation = bankLocation;
        this.bankCode = bankCode;
        this.nationalCurrency = nationalCurrency;
        this.bankLicenseExpDate = bankLicenseExpDate;
        this.minAccountAmount = minAccountAmount;
        this.bankClients = bankClients;
    }


    public void addClient(Client client) {
        if (checkClient(client)){
            for (int i = 0; i < bankClients.length; i++) {
                if (bankClients[i] == null) {
                    bankClients[i] = client;
                    System.out.println("Уважаемый(ая) " + client.firstName + " " + client.lastName);
                    System.out.println("Поздравляем! Вы стали клиентом " + bankName);
                    break;
                } else {
                    if (i == (bankClients.length - 1)){
                        System.out.println("Нового клиента добавить не удалось. Массив клиентов заполнен");
                    }
                }
            }

        }
    }

    public boolean checkClient(Client client){
        boolean tmp = true;
        for (int i = 0; i < bankClients.length; i++) {
            if (!(bankClients[i] == null)) {
                if (bankClients[i].equals(client)){
                    System.out.println("Такой клиент уже существует");
                    tmp = false;
                }
            }
        }
        return tmp;
    }

    public void deleteClientExpAccounts(Account... clientAccounts){
        System.out.println("Автоматическое удаление счетов с истекшим сроком запущено");
        for (int i = 0; i < bankClients.length; i++){
            for (int j = 0; j < clientAccounts.length; j++){
                if (!(clientAccounts[j] == null)){
                    if (clientAccounts[j].accountExpDate.isBefore(LocalDate.now())) {
                        System.out.println("Счет " + clientAccounts[j].accountNumber + " автоматически удален");
                        clientAccounts[j] = null;
                        break;
                    }
                }
            }
        }
    }







}
