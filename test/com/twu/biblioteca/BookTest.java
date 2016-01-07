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
        assertEquals(String.format("%-6d %-12d %-25s %-20s %d", 0, 1234, "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }

    @Test
    public void representUnavailableBookAsAString() {
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertEquals(String.format("%-6d %-12s %-25s %-20s %d", 0, "Unavailable", "Harry Potter", "J.K.Rowling", 2005), book.toString());
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
}
