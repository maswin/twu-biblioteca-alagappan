package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private Map<Book, Set<Integer>> borrowedBooks;

    public Library(List<Book> books, Map<Book, Set<Integer>> borrowedBooks) {
        this.books = books;
        this.borrowedBooks = borrowedBooks;
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
            if(borrowedBooks.containsKey(book)) {
                borrowedBooks.get(book).add(isbn);
            } else {
                Set<Integer> isbns = new HashSet<>();
                isbns.add(isbn);
                borrowedBooks.put(book, isbns);
            }
            return true;
        }
        return false;
    }

    private boolean isAllBooksBorrowed(Book book) {
        if(borrowedBooks.containsKey(book)) {
            return borrowedBooks.get(book).size() == book.numberOfBooksAvailable();
        }
        return false;
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
        for(Map.Entry<Book, Set<Integer>> bookSetEntry : borrowedBooks.entrySet()) {
            Set<Integer> isbns = bookSetEntry.getValue();
            if(isbns.contains(isbn)) {
                return true;
            }
        }
        return false;
    }

    private Book findBorrowedBookByIsbn(int isbn) {
        if(isBorrowedBook(isbn)) {
            for(Map.Entry<Book, Set<Integer>> bookSetEntry : borrowedBooks.entrySet()) {
                Set<Integer> isbns = bookSetEntry.getValue();
                if(isbns.contains(isbn)) {
                    return bookSetEntry.getKey();
                }
            }
        }
        return null;
    }

    public boolean checkIn(int isbn) {
        Book book = findBorrowedBookByIsbn(isbn);
        if(book != null) {
            borrowedBooks.get(book).remove(isbn);
            if(borrowedBooks.get(book).size() == 0) {
                borrowedBooks.remove(book);
            }
        }
        return false;
    }
}
