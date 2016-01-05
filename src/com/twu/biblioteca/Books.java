package com.twu.biblioteca;

import java.util.List;
import java.util.Optional;

public class Books {
    private List<Book> bookList;

    public Books(List<Book> bookList) {
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
            book.checkOut();
            return true;
        }
        return false;
    }
}
