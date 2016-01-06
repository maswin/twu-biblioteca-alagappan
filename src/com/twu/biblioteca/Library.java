package com.twu.biblioteca;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Book> borrowedBooks;

    public Library(List<Book> books, List<Book> borrowedBooks) {
        this.books = books;
        this.borrowedBooks = borrowedBooks;
    }

    private Book findBookById(int bookId) {
        Optional<Book> foundBook = books.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
        if(foundBook.isPresent()) {
            return foundBook.get();
        }
        return null;
    }

    private Book findBorrowedBookById(int bookId) {
        Optional<Book> foundBook = borrowedBooks.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
        if(foundBook.isPresent()) {
            return foundBook.get();
        }
        return null;
    }

    public boolean checkOut(int bookId) {
        Book book = findBookById(bookId);
        if(book != null) {
            books.remove(book);
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public List<Book> getDistinctListOfBooks() {
        return books.stream().distinct().collect(Collectors.toList());
    }

    public boolean isBookAvailable(int bookId) {
        Optional<Book> foundBook = books.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
        return foundBook.isPresent();
    }

    public boolean isBorrowedBook(int bookId) {
        Optional<Book> foundBook = borrowedBooks.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
        return foundBook.isPresent();
    }

    public boolean checkIn(int bookId) {
        Book book = findBorrowedBookById(bookId);
        if(book != null) {
            books.add(book);
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }
}
