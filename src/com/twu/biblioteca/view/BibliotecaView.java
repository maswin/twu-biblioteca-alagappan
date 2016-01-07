package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.DTO.BookDTO;
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

    public void printBooks(List<BookDTO> books) {
        outputWriter.println("List Of Books Available");
        outputWriter.println(String.format("%-12s %-25s %-20s %s", "ISBN", "Book Name", "Author Name", "Year"));
        books.forEach(bookDTO ->  outputWriter.println(String.format("%-12d %-25s %-20s %d", bookDTO.getIsbn(),
                bookDTO.getName(), bookDTO.getAuthorName(), bookDTO.getYearPublished())));
    }

    public int getBookId() {
        outputWriter.println("Enter Book ISBN :");
        return inputReader.readInt();
    }

    public void printSuccessfulBookCheckoutMessage() {
        outputWriter.println("Thank you! Enjoy the book");
    }

    public void printUnSuccessfulBookCheckoutMessage() {
        outputWriter.println("That book is not available.");
    }

    public void printSuccessfulBookCheckInMessage() {
        outputWriter.println("Thank you for returning the book.");
    }

    public void printUnSuccessfulBookCheckInMessage() {
        outputWriter.println("That is not a valid book to return.");
    }

}
