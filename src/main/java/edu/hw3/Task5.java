package edu.hw3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task5 {
    private Task5() {
    }

    public static Object[] parseContacts(String[] contacts, String orderInstruction) {
        if (contacts == null) {
            return new Object[] {};
        }

        var orderedContacts = new ArrayList<String>();

        Map<String, String> map = new HashMap<>();

        for (String contact : contacts) {
            String[] data = contact.split(" ");

            if (data.length > 2
                    || data.length == 0) {
                throw new IllegalArgumentException("Invalid format");
            }

            String name = data[0];
            String surname = data[1];

            if (surname == null) {
                orderedContacts.add(name);
                map.put(name, "");
            } else {
                orderedContacts.add(surname);
                map.put(surname, name);
            }
        }

        Collections.sort(orderedContacts);

        if (orderInstruction.equals("ASC")) {
            Collections.sort(orderedContacts);
        } else if (orderInstruction.equals("DESC")) {
            orderedContacts.sort(Collections.reverseOrder());
        } else {
            throw new IllegalArgumentException("Invalid order instruction");
        }

        var result = new ArrayList<String>();

        for (String alias : orderedContacts) {
            result.add(map.get(alias) + " " + alias);
        }

        return result.toArray();
    }
}
