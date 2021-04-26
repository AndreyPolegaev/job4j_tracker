package ru.job4j.function.streamapi.adress;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void firstTest() {
        Profile firstClient = new Profile(new Address("Moscow", "Street1", 1, 10));
        Profile secondClient = new Profile(new Address("Briansk", "Street2", 2, 16));
        Profile thirdClient = new Profile(new Address("Tomsk", "Street3", 3, 37));
        List<Profile> list = List.of(
                firstClient,
                secondClient,
                thirdClient
        );
        List<Address> rsl = new Profiles().collect(list);
        List<Address> expected = List.of(
                new Address("Briansk", "Street2", 2, 16),
                new Address("Moscow", "Street1", 1, 10),
                new Address("Tomsk", "Street3", 3, 37)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenWasDeleteDuplicate() {
        Profile firstClient = new Profile(new Address("Moscow", "Street1", 1, 10));
        Profile secondClient = new Profile(new Address("Briansk", "Street2", 2, 16));
        Profile thirdClient = new Profile(new Address("Tomsk", "Street3", 3, 37));
        Profile fourthClient = new Profile(new Address("Tomsk", "Street3", 3, 37));
        List<Profile> list = List.of(
                firstClient,
                secondClient,
                thirdClient,
                fourthClient
        );
        List<Address> rsl = new Profiles().collect(list);
        List<Address> expected = List.of(
                new Address("Briansk", "Street2", 2, 16),
                new Address("Moscow", "Street1", 1, 10),
                new Address("Tomsk", "Street3", 3, 37)
        );
        assertThat(rsl, is(expected));
    }
}