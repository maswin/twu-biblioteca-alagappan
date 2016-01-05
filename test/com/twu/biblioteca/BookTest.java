package com.twu.biblioteca;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void representBookAsAString() throws Exception {
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005);
        assertEquals(String.format("0 %-25s %-20s %d", "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }
}
