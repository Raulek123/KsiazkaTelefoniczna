package KsiazkaTelefoniczna.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactEntity implements Comparable<ContactEntity>{
    private String name;
    private int phoneNumber;

    @Override
    public int compareTo(ContactEntity c) {
        return this.name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }

    public String toCSV() {
        return name + ";" + phoneNumber;
    }

}
