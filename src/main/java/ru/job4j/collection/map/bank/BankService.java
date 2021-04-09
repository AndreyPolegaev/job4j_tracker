package ru.job4j.collection.map.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банка.
 * @Autor Andrey Polegaev
 * @Version 1.0
 */
public class BankService {
    /**
     * Хранение пары пользователь и его счета, осуществляется в коллекции типа Map.
     * У пользователя может быть несколько счетов.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в Map, если такой отсутствует.
     * Так же добавляет пустую коллекцию счетов типа ArrayList.
     * @param user пользователь, который добавляется в Map
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователя, если такой счет отсутствует.
     * @param passport поиск пользователя по паспорту в методе findByPassport.
     * @param account  счет, который дабавляется в ArrayList.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAccount = users.get(user);
            if (!listAccount.contains(account)) {
                listAccount.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту в коллекции Map.
     * @param passport паспорта пользователя.
     * @return получаем пользователя, если такой номер паспорта есть в ключах коллекции Map.
     * null, если пользователя с таким паспортом нет.
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                user = temp;
                break;
            }
        }
        return user;
    }

    /**
     * Мето ищет счет пользователя по паспорту и реквизитам.
     * @param passport по паспорту находим пользователя, используя меод findByPassport,
     * получаем список его счетов в Map.
     * @param requisite реквизиты счета пользователя. Если пользователь с таким паспортом существует
     * ищем в списке его счетов счет с такими реквизитами.
     * @return возвращает счет пользователя или null, если такого пользователя нет в Map.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (user != null) {
            for (Account temp : list) {
                if (temp.getRequisite().equals(requisite)) {
                    account = temp;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод осуществляет перевод денег со счета на счет, ищет счет по паспорту и реквизитам счета.
     * Ищет нужный счет через метод findByRequisite.
     * @param srcPassport паспорт отправителя.
     * @param srcRequisite реквизиты его счета отправителя.
     * @param destPassport паспорт получателя.
     * @param destRequisite реквизиты счета получателя.
     * @param amount сумма к переводу
     * @return true, если перевод прошел успешно, false в противном случае.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}