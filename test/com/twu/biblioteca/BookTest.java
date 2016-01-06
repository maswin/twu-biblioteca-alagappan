package com.twu.biblioteca;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void representBookAsAString() {
        Book book = new Book(0, "Harry Potter", "J.K.Rowling", 2005);
        assertEquals(String.format("0 %-25s %-20s %d", "Harry Potter", "J.K.Rowling", 2005), book.toString());
    }

    @Test
    public void booksWithSameNameAuthorNameAndYearAreEqual() {
        Book book1 = new Book(0, "Harry Potter", "J.K.Rowling", 2005);
        Book book2 = new Book(1, "Harry Potter", "J.K.Rowling", 2005);
        assertEquals(book1, book2);
    }
}
