package KsiazkaTelefoniczna.io;

import java.util.Scanner;

public class Reader {
    private final Scanner sc = new Scanner(System.in);

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        String line = sc.nextLine();
        if (line == null) {
            throw new NullPointerException("Cannot be null");
        }
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        } else {
            return line;
        }
    }

    public void close() {
        sc.close();
    }
}
