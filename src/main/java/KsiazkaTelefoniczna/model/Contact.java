package KsiazkaTelefoniczna.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
    private String name;
    private int phoneNumber;

    @Override
    public String toString() {
        return "Kontakt: " + name + ", numer telefonu: " + phoneNumber;
    }
}
