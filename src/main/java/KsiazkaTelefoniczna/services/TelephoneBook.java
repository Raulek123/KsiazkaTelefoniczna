package KsiazkaTelefoniczna.services;

import KsiazkaTelefoniczna.model.ContactEntity;
import KsiazkaTelefoniczna.exception.NoContactFoundException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TelephoneBook {
    private Map<String, ContactEntity> contactsMap = new TreeMap<>();

    public void addNewContact(String name, int phoneNumber) {
        contactsMap.put(name, new ContactEntity(name, phoneNumber));
    }

    public List<ContactEntity> printContact() {
        return contactsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public void deletingContactByName(String name) {
        if (!contactsMap.containsKey(name)) {
            throw new NoContactFoundException(name);
        }
            contactsMap.remove(name);
    }

    public List<ContactEntity> searchContactByNameOrPhoneNumber(String searchContact) {
        return contactsMap.values()
                .stream()
                .filter(contactEntity -> Integer.toString(contactEntity.getPhoneNumber()).contains(searchContact)
                        || contactEntity.getName().contains(searchContact))
                .collect(Collectors.toList());
    }
}
