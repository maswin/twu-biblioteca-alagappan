package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private Set<Integer> borrowedIsbns;

    public Library(List<Book> books, Set<Integer> borrowedIsbns) {
        this.books = books;
        this.borrowedIsbns = borrowedIsbns;
    }

    private Book findBookByIsbn(int isbn) {
        Optional<Book> foundBook = books.stream().filter(b -> b.isIsbnOfThisBookType(isbn)).findFirst();
        if(foundBook.isPresent()) {
            return foundBook.get();
        }
        return null;
    }

    public boolean checkOut(int isbn) {
        Book book = findBookByIsbn(isbn);
        if(book != null) {
            borrowedIsbns.add(isbn);
            return true;
        }
        return false;
    }

    private boolean isAllBooksBorrowed(Book book) {
        int numberOfCopiesBorrowedOfThisBook = findNumberOfCopiesBorrowedOfThisBook(book);
        return book.numberOfBooksAvailable() == numberOfCopiesBorrowedOfThisBook;
    }

    private int findNumberOfCopiesBorrowedOfThisBook(Book book) {
        int numberOfCopiesBorrowedOfThisBook = 0;
        for(Integer isbn : borrowedIsbns) {
            book.isIsbnOfThisBookType(isbn);
            numberOfCopiesBorrowedOfThisBook++;
        }
        return numberOfCopiesBorrowedOfThisBook;
    }

    public List<Book> getListOfAvailableBooks() {
        return books.stream().filter(book -> !isAllBooksBorrowed(book)).collect(Collectors.toList());
    }

    public boolean isBookAvailable(int isbn) {
        Optional<Book> foundBook = books.stream().filter(book ->
                book.isIsbnOfThisBookType(isbn) && !isAllBooksBorrowed(book)
        ).findFirst();
        return foundBook.isPresent();
    }

    public boolean isBorrowedBook(int isbn) {
        return borrowedIsbns.contains(isbn);
    }

    public boolean checkIn(int isbn) {
        if(isBorrowedBook(isbn)) {
            borrowedIsbns.remove(isbn);
            return true;
        }
        return false;
    }
}
