package KsiazkaTelefoniczna;

import KsiazkaTelefoniczna.Controller.TelephoneBookController;

public class TelephoneBookApp {
    public static void main(String[] args) {
        TelephoneBookController telephoneBookController = new TelephoneBookController();
        telephoneBookController.loop();
    }
}
