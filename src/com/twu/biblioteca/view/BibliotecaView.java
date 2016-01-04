package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InputOutput.OutputWriter;

import java.util.List;

public class BibliotecaView {
    private final String welcomeMessage;
    private final OutputWriter outputWriter;

    public BibliotecaView(String welcomeMessage, OutputWriter outputWriter) {
        this.welcomeMessage = welcomeMessage;
        this.outputWriter = outputWriter;
    }

    public void printWelcomeMessage() {
        outputWriter.println(welcomeMessage);
    }

    public void printBooks(List<Book> books) {
        outputWriter.println("List Of Books Available");
        for(Book book : books) {
            outputWriter.println(book);
        }
    }
}
