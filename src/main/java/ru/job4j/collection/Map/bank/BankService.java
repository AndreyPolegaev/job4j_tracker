package ru.job4j.collection.Map.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>(); /*Это поле содержит всех пользователей системы с привязанными к ним счетами.*/

    public void addUser(User user) {  /*Добавить пользователя в систему, если такого еще нет */
        for (User temp : users.keySet()) {
             if (!temp.getPassport().equals(user.getPassport())) {
                 users.put(user, new ArrayList<Account>());
             }
        }
    }

    public void addAccount(String passport, Account account) {  /* Должен добавить новый счет к пользователю, найти по паспорту */
        User user = findByPassport(passport);
        List<Account> listAccount = users.get(user);
        for (Account temp : listAccount) {
            if (!temp.equals(account)) {
                listAccount.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                user = temp;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account temp : list) {
            if (temp.getRequisite().equals(requisite)) {
                account = temp;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
