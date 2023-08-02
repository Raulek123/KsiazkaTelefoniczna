package KsiazkaTelefoniczna.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneBookControllerTest {
    @Test
    void test() {
        // given
        TelephoneBookController telephoneBookController = new TelephoneBookController();

        //when
        telephoneBookController.loop();

        //then
    }

}