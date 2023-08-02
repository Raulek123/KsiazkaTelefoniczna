package KsiazkaTelefoniczna.enums;

import java.util.NoSuchElementException;

public enum AppOptions {
    EXIT(0, "Wyjście z programu"),
    ADD_CONTACT(1, "Dodaj kontakt"),
    PRINT_ALL_CONTACT(2, "Wyświetl wszystkie kontakty"),
    FIND_BY_NAME(3, "Szukaj po nazwie"),
    FIND_BY_PHONE_NUMBER(4, "Szukaj po numerze telefonu"),
    REMOVAL(5, "Usuń kontakt");

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
            throw new NoSuchElementException("Brak opcji o numerze: " + option + ", wprowadź prawidłową wartość");
        }
    }

    @Override
    public String toString() {
        return optionIndex + " - " + description;
    }
}
