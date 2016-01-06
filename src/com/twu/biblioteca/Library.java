package com.twu.biblioteca;

import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book findBookById(int bookId) {
        Optional<Book> foundBook = bookList.stream().filter(b -> b.isSameBookId(bookId)).findFirst();
        if(foundBook.isPresent()) {
            return foundBook.get();
        }
        return null;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean checkOut(int bookId) {
        Book book = findBookById(bookId);
        if(book != null) {
            bookList.remove(book);
            return true;
        }
        return false;
    }
}
