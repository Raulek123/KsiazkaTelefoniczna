package KsiazkaTelefoniczna.io;

import KsiazkaTelefoniczna.exception.DataImportException;
import KsiazkaTelefoniczna.model.ContactEntity;
import KsiazkaTelefoniczna.services.TelephoneBook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "Contacts.csv";

    @Override
    public TelephoneBook importData() {
        TelephoneBook telephoneBook = new TelephoneBook();
        importContacts(telephoneBook);
        return telephoneBook;
    }

    @Override
    public void exportData(TelephoneBook telephoneBook) {

    }

    private void importContacts(TelephoneBook telephoneBook) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(contactEntity -> telephoneBook.addNewContact(contactEntity.getName(), contactEntity.getPhoneNumber()));
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + FILE_NAME);
        }
    }

    private ContactEntity createObjectFromString(String line) {
        String[] split = line.split(";");
        return createContact(split);
    }


    private ContactEntity createContact(String[] data) {
        String name = data[0];
        int phoneNumber = Integer.parseInt(data[1]);
        return new ContactEntity(name, phoneNumber);
    }
}
