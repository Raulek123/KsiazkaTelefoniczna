package KsiazkaTelefoniczna.Controller;

import KsiazkaTelefoniczna.enums.AppOptions;
import KsiazkaTelefoniczna.io.ConsolePrinter;
import KsiazkaTelefoniczna.services.TelephoneBook;

import java.util.Scanner;

public class TelephoneBookController {
    private TelephoneBook teleBook = new TelephoneBook();
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

    public void loop() {

    }

    private void showOptions() {
        printer.printLine("\n Wybierz opcję:");
        for (AppOptions value : AppOptions.values()) {
            System.out.println(value.toString());
        }
    }

    private AppOptions choseOption() {
        int result = sc.nextInt();
        return AppOptions.convertNumberToOption(result);
    }

    private void executeOption(AppOptions options) {
       showOptions();
       choseOption();
    }

    private void delete() {
        printer.printLine("Wprowadź nazwę do usunięcia:");
        String name = sc.nextLine();
        teleBook.deletingContactByName(name);
    }

    private void searchByTelephone() {
        printer.printLine("Wprowadź numer telefonu kontaktu, którego szukasz:");
        String number = sc.nextLine();
        teleBook.searchContactByNameOrPhoneNumber(number);
    }

    private void searchByName() {
        printer.printLine("Wprowadź nazwę kontaktu, którego szukasz");
        String name = sc.nextLine();
        teleBook.searchContactByNameOrPhoneNumber(name);
    }

    private void addContact() {
        printer.printLine("Wprowadź nazwę kontaktu:");
        String name = sc.nextLine();
        printer.printLine("Wprowadź numer telefonu:");
        int number = sc.nextInt();
        teleBook.addNewContact(name, number);
    }

    private void close() {
        printer.printLine("Do zobaczenia!");
        sc.close();
    }
}
