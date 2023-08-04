package KsiazkaTelefoniczna.io;

import KsiazkaTelefoniczna.exception.DataImportException;
import KsiazkaTelefoniczna.model.ContactEntity;
import KsiazkaTelefoniczna.services.TelephoneBook;

import java.io.*;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "src/main/resources/Contacts.csv";

    @Override
    public TelephoneBook importData() {
        TelephoneBook telephoneBook = new TelephoneBook();
        importContacts(telephoneBook);
        return telephoneBook;
    }

    @Override
    public void exportData(TelephoneBook telephoneBook) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (ContactEntity contact : telephoneBook) {
            writer.write(contact.toCSV());
            writer.newLine();
        }
        writer.close();
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
