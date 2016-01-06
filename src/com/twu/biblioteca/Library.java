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

    public Book findBookById(int bookId) {
        Optional<Book> foundBook = books.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
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
}
