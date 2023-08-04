package KsiazkaTelefoniczna.io;

import KsiazkaTelefoniczna.services.TelephoneBook;

import java.io.IOException;

public interface FileManager {
    TelephoneBook importData();

    void exportData(TelephoneBook telephoneBook) throws IOException;
}
