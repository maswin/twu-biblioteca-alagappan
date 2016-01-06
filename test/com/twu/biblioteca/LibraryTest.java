package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private List<Book> bookList;

    @Before
    public void setUp() throws Exception {
        bookList = new ArrayList<>();
        bookList.add(new Book(1,"book1", "author1", 2012));
        bookList.add(new Book(2,"book2", "author2", 2013));
        bookList.add(new Book(3,"book3", "author3", 2014));
    }

    @Test
    public void shouldReturnBookIfIdMatchesExistingBookID() {
        Book book = new Book(21,"book4", "author4", 2000);
        bookList.add(book);
        Library library = new Library(bookList);
        assertEquals(book, library.findBookById(21));
    }

    @Test
    public void shouldReturnNullIfIdMatchesNoExistingBookID() {
        Library library = new Library(bookList);
        assertEquals(null, library.findBookById(21));
    }

    @Test
    public void shouldMakeBookUnAvailableWhenCheckedOut() {
        Book book = new Book(21,"book4", "author4", 2000);
        bookList.add(book);
        Library library = new Library(bookList);
        library.checkOut(21);
        assertEquals(3, bookList.size());
    }
}
