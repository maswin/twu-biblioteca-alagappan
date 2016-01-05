package com.twu.biblioteca.InputOutput;

import java.util.Scanner;

public class InputReader {
    private Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.next();
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
