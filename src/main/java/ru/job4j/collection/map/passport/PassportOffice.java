package ru.job4j.collection.map.passport;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen citizen = null;
        for (String key : citizens.keySet()) {
            if (key.equals(passport)) {
                citizen = citizens.get(key);
            }
        }
        return citizen;
    }
}
