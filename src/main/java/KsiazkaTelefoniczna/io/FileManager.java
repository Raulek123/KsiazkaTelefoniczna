package KsiazkaTelefoniczna.io;

import KsiazkaTelefoniczna.services.TelephoneBook;

public interface FileManager {
    TelephoneBook importData();

    void exportData(TelephoneBook telephoneBook);
}
