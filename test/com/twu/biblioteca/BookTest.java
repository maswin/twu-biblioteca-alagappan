package com.twu.biblioteca;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void representBookAsAString() {
        List<Integer> isbn = new ArrayList<>();
        isbn.add(1234);
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertEquals(String.format("%-6d %-12d %-25s %-20s %d", 0, 1234, "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }

    @Test
    public void representUnavailableBookAsAString() {
        List<Integer> isbn = new ArrayList<>();
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005, isbn);
        assertEquals(String.format("%-6d %-12s %-25s %-20s %d", 0, "Unavailable", "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }
}
