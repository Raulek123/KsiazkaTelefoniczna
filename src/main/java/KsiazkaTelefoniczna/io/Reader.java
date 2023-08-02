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
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
