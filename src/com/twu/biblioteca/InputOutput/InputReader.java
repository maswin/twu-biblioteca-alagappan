package com.twu.biblioteca.InputOutput;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;

    public InputReader(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public String read() {
        return scanner.next();
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
