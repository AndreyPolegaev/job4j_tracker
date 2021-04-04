package ru.job4j.collection.Map.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>(); /*Это поле содержит всех пользователей системы с привязанными к ним счетами.*/

    public void addUser(User user) {  /*Добавить пользователя в систему, если такого еще нет */
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {  /* Должен добавить новый счет к пользователю, найти по паспорту */
        User user = findByPassport(passport);
        List<Account> listAccount = users.get(user); /* получить список его счетов */
        if (!listAccount.contains(account)) {
            listAccount.add(account);
        }
    }

    public User findByPassport(String passport) { /* поиск юзера по паспорту */
        User user = null;
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                user = temp;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) { /* метод ищет счет пользователя по реквизитам */
        Account account = null;
        User user = findByPassport(passport);
        List<Account> list = users.get(user); /* получить список его счетов */
        if (user != null && !list.isEmpty()) {
            for (Account temp : list) {
                if (temp.getRequisite().equals(requisite)) {
                    account = temp;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
