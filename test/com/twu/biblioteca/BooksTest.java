package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class BooksTest {

    private List<Book> bookList;

    @Before
    public void setUp() throws Exception {
        bookList = new ArrayList<>();
        bookList.add(new Book(1,"book1", "author1", 2012, true));
        bookList.add(new Book(2,"book2", "author2", 2013, true));
        bookList.add(new Book(3,"book3", "author3", 2014, true));
    }

    @Test
    public void shouldReturnBookIfIdMatchesExistingBookID() {
        Book book = new Book(21,"book4", "author4", 2000, true);
        bookList.add(book);
        Books books = new Books(bookList);
        assertEquals(book, books.findBookById(21));
    }

    @Test
    public void shouldReturnNullIfIdMatchesNoExistingBookID() {
        Books books = new Books(bookList);
        assertEquals(null, books.findBookById(21));
    }

    @Test
    public void shouldMakeBookUnAvailableWhenCheckedOut() {
        Book book = new Book(21,"book4", "author4", 2000, true);
        bookList.add(book);
        Books books = new Books(bookList);
        books.checkOut(21);
        assertFalse(book.isBookAvailable());
    }
}
