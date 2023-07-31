package KsiazkaTelefoniczna;

import KsiazkaTelefoniczna.Exception.NoContactFoundException;

public class Test {
    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.addNewContact("Krystian", 505669336);
        telephoneBook.addNewContact("Ada", 606669336);
        telephoneBook.printContact().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");


    }
}
