package KsiazkaTelefoniczna.enums;

import java.util.NoSuchElementException;

enum AppOptions {
    ADD_CONTACT(0, "Dodaj kontakt"),
    FIND_BY_NAME(1, "Szukaj po nazwie"),
    FIND_BY_PHONE_NUMBER(2, "Szukaj po numerze telefonu"),
    REMOVAL(3, "Usuwanie"),
    EXIT(4, "Wyjście z programu");

    private int optionIndex;
    private String description;

    AppOptions(int optionIndex, String description) {
        this.optionIndex = optionIndex;
        this.description = description;
    }

    public int getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AppOptions convertNumberToOption(int option) {
        try {
            return AppOptions.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException("Brak opcji o numerze: " + option);
        }
    }

    @Override
    public String toString() {
        return optionIndex + " - " + description;
    }
}
