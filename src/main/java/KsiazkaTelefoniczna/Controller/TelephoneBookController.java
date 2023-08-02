package KsiazkaTelefoniczna.Controller;

import KsiazkaTelefoniczna.enums.AppOptions;
import KsiazkaTelefoniczna.io.ConsolePrinter;
import KsiazkaTelefoniczna.io.Reader;
import KsiazkaTelefoniczna.services.TelephoneBook;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TelephoneBookController {
    private final TelephoneBook teleBook = new TelephoneBook();
    private final ConsolePrinter printer = new ConsolePrinter();
    private final Reader reader = new Reader();

    public void loop() {
        AppOptions option;
        do {
            showOptions();
            option = choseOption();
            executeOption(option);
        } while (option != AppOptions.EXIT);
    }

    private void showOptions() {
        printer.printLine("\n >>> Wybierz opcje:");
        for (AppOptions value : AppOptions.values()) {
            System.out.println(value.toString());
        }
    }

    private AppOptions choseOption() {
        boolean optionOk = false;
        AppOptions option = null;
        while (!optionOk) {
            try {
                option = AppOptions.convertNumberToOption(reader.getInt());
                optionOk = true;
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzona wartość nie jest liczbą, podaj ponownie opcję");
            } catch (NoSuchElementException e) {
                printer.printLine(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(AppOptions options) {
       switch (options){
           case PRINT_ALL_CONTACT -> printContact();
           case ADD_CONTACT -> addContact();
           case FIND_BY_NAME -> searchByName();
           case FIND_BY_PHONE_NUMBER -> searchByTelephone();
           case REMOVAL -> delete();
           case EXIT -> closeApp();
           default -> System.out.println("Nie ma takiej opcji, wprowadź ponownie");
       }
    }

    private void printContact() {
        printer.printLine("Lista kontaktów:");
        teleBook.printContact().forEach(System.out::println);
    }

    private void delete() {
        printer.printLine("Wprowadź nazwę do usunięcia:");
        String name = reader.getString();
        teleBook.deletingContactByName(name);
        printer.printLine("Usunięto kontakt");
    }

    private void searchByTelephone() {
        printer.printLine("Wprowadź numer telefonu kontaktu, którego szukasz:");
        String number = reader.getString();
        teleBook.searchContactByNameOrPhoneNumber(number);
    }

    private void searchByName() {
        printer.printLine("Wprowadź nazwę kontaktu, którego szukasz");
        String name = reader.getString();
        teleBook.searchContactByNameOrPhoneNumber(name);
    }

    private void addContact() {
        printer.printLine("Wprowadź nazwę kontaktu:");
        String name = reader.getString();
        printer.printLine("Wprowadź numer telefonu:");
        int number = reader.getInt();
        teleBook.addNewContact(name, number);
        printer.printLine("Dodano nowy kontakt");
    }

    private void closeApp() {
        printer.printLine("Do zobaczenia!");
        reader.close();
    }
}
