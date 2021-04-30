package ru.job4j.collection.map.bank;

import javax.swing.text.html.Option;
import java.util.*;

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
        Optional<User> opt = findByPassport(passport);
        if (opt.isPresent()) {
            List<Account> listAccount = users.get(opt.get());
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> empty = Optional.empty();
        Optional<User> rsl = users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
        if (rsl.isPresent()) {
            return rsl;
        }
        return empty;
    }

    /**
     * Мето ищет счет пользователя по паспорту и реквизитам.
     * @param passport по паспорту находим пользователя, используя меод findByPassport,
     * получаем список его счетов в Map.
     * @param requisite реквизиты счета пользователя. Если пользователь с таким паспортом существует
     * ищем в списке его счетов счет с такими реквизитами.
     * @return возвращает счет пользователя или null, если такого пользователя нет в Map.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
                     rsl = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && srcAccount.get().getBalance() >= amount && destAccount.isPresent()) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}