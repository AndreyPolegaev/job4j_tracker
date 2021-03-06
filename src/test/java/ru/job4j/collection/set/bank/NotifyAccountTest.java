package ru.job4j.collection.set.bank;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

    public class NotifyAccountTest {

        @Test
        public void sent() {
            List<Account> accounts = List.of(
                    new Account("123", "Petr Arsentev", "eDer3432f"),
                    new Account("142", "Petr Arsentev", "000001")
            );
            HashSet<Account> expect = new HashSet<>(
                    Set.of(
                            new Account("123", "Petr Arsentev", "eDer3432f"),
                            new Account("142", "Petr Arsentev", "000001")
                    )
            );
            assertThat(NotifyAccount.sent(accounts), is(expect));
        }

        @Test
        public void chech() {
            List<Account> accounts = List.of(
                    new Account("565", "Andrey", "vwevw"),
                    new Account("565", "Andrey", "vwevw"),
                    new Account("565", "Andrey", "vwevw")
            );
            HashSet<Account> expected = new HashSet<>(Set.of(
                    new Account("565", "Andrey", "vwevw"))
            );
            assertThat(NotifyAccount.sent(accounts), is(expected));
        }
    }
