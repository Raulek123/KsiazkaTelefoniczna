package KsiazkaTelefoniczna.Exception;

public class NoContactFoundException extends RuntimeException{
    public NoContactFoundException(String name) {
        super("Nie odnaleziono podanego kontaktu: " + name);
    }
}
