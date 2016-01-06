package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

import java.util.List;

public class BibliotecaView {
    private final String welcomeMessage;
    private final OutputWriter outputWriter;
    private InputReader inputReader;

    public BibliotecaView(String welcomeMessage, OutputWriter outputWriter, InputReader inputReader) {
        this.welcomeMessage = welcomeMessage;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void printWelcomeMessage() {
        outputWriter.println(welcomeMessage);
    }

    public void printBooks(List<Book> books) {
        outputWriter.println("List Of Books Available");
        outputWriter.println(String.format("%10s %-25s %-20s %s", "ISBN", "Book Name", "Author Name", "Year"));
        books.forEach(book ->  outputWriter.println(book));
    }

    public int getBookId() {
        outputWriter.println("Enter Book Id :");
        return inputReader.readInt();
    }

    public void printSuccessfulBookCheckoutMessage() {
        outputWriter.println("Thank you! Enjoy the book");
    }

    public void printUnSuccessfulBookCheckoutMessage() {
        outputWriter.println("That book is not available.");
    }

}
