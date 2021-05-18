package com.tms.homework5.client;

import com.tms.homework5.account.Account;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 *  Класс  Client
 *  checkGender - проверяет строку пол
 *  openAccount - добавляет новый счет в массив счетов клиента
 *  changeAccount - меняет сумму на счету клиента
 *  deleteAccount - обнуляет выбранный счет
 */
public class Client {

    public String lastName;
    public String firstName;
    public LocalDate dateOfBirth;
    public String passportNumber;
    public String gender;
    public Account[] clientAccounts;

    public Client(String lastName, String firstName, LocalDate dateOfBirth, String passportNumber, String gender,
                  Account[] clientAccounts) {
        if (checkGender(gender)) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.dateOfBirth = dateOfBirth;
            this.passportNumber = passportNumber;
            this.gender = gender;
            this.clientAccounts = clientAccounts;
        } else {
            System.out.println("Пользователь не создан. Неправильно указан пол.");
        }
    }

    boolean checkGender(String gender){
        return gender == "male" || gender == "female";
    }

    public void openAccount(Account account){
        if (checkAccount(account)){
                for (int i = 0; i < clientAccounts.length; i++) {
                    if (clientAccounts[i] == null) {
                        clientAccounts[i] = account;
                        System.out.println("Счет " + clientAccounts[i].accountNumber + " открыт");
                            break;
                    } else {
                        if (i == (clientAccounts.length - 1)){
                            System.out.println("Новый счет открыть не удалось. Счетов слишком много");
                        }
                    }
                }
        }
    }

    public void changeAccount(Account account, double newAccountAmount){
        for (int i = 0; i < clientAccounts.length; i++) {
            if (!(clientAccounts[i] == null)){
                if (clientAccounts[i].equals(account)){
                    if (newAccountAmount > 0) {
                        clientAccounts[i].accountAmount += newAccountAmount;
                        System.out.println("Счет " + clientAccounts[i].accountNumber + " увеличен на " + newAccountAmount);
                        System.out.println("Сумма на счету " + clientAccounts[i].accountAmount);
                        break;
                    } else {
                        System.out.println("Сумма на счету не может быть меньше нуля.");
                        break;
                    }
                }  else {
                    System.out.println("Такого счета в базе нет");
                    break;
                }
            }
        }
    }

    public void deleteAccount(Account account){
        for (int i = 0; i < clientAccounts.length; i++) {
            if (!(clientAccounts[i] == null)){
                if (clientAccounts[i].equals(account)){
                    clientAccounts[i] = null;
                    break;
                    } else {
                    System.out.println("Такого счета в базе нет");
                    break;
                }
            }
        }
    }




    public boolean checkAccount (Account account){
        boolean tmp = true;
        for (int i = 0; i < clientAccounts.length; i++) {
            if (!(clientAccounts[i] == null)) {
                if (clientAccounts[i].equals(account)){
                    System.out.println("Такой счет уже существует");
                    tmp = false;
                }
            }
        }
        return tmp;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(lastName, client.lastName) && Objects.equals(firstName, client.firstName) && Objects.equals(passportNumber, client.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, passportNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "lastName='" + lastName + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportNumber='" + passportNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", clientAccounts=" + Arrays.toString(clientAccounts) +
                '}';
    }
}
