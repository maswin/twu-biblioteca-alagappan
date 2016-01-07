package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    private Set<Integer> isbn;

    @Before
    public void setUp() throws Exception {
        isbn = new HashSet<>();
    }

    @Test
    public void representBookAsAString() {
        isbn.add(1234);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertEquals(String.format("%-25s %-20s %d", "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }


    @Test
    public void checkIfTheISBNBelongsToThisBook() {
        isbn.add(2345);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertTrue(book.isIsbnOfThisBookType(2345));
    }

    @Test
    public void shouldReturnTheNumberOfBooksAvailable() {
        isbn.add(2345);
        isbn.add(3456);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertEquals(2, book.numberOfBooksAvailable());
    }

    @Test
    public void shouldReturnFalseIfNoBookIsAvailable() {
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertFalse(book.isAnyBookAvailable());
    }

    @Test
    public void shouldReturnFirstAvailableIsbnNotInUnavailableIsbnSet() {
        isbn.add(2345);
        isbn.add(3456);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        Set<Integer> unavailableIsbn = new HashSet<>();
        unavailableIsbn.add(2345);
        assertEquals(3456, book.getFirstAvailableIsbn(unavailableIsbn));
    }
}
