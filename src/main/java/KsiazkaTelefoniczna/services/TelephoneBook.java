package KsiazkaTelefoniczna.services;

import KsiazkaTelefoniczna.model.Contact;
import KsiazkaTelefoniczna.exception.NoContactFoundException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TelephoneBook {
    private Map<String, Contact> contactsMap = new TreeMap<>();

    public void addNewContact(String name, int phoneNumber) {
        contactsMap.put(name, new Contact(name, phoneNumber));
    }

    public List<Contact> printContact() {
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

    public List<Contact> searchContactByNameOrPhoneNumber(String searchContact) {
        return contactsMap.values()
                .stream()
                .filter(contact -> Integer.toString(contact.getPhoneNumber()).contains(searchContact)
                        || contact.getName().contains(searchContact))
                .collect(Collectors.toList());
    }
}
