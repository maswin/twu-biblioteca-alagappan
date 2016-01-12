package com.twu.biblioteca.model.Books;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookTest {

    @Test
    public void shouldGenerateBookDTO() throws LibraryItemProcessingException {
        Copy copy = Mockito.mock(Copy.class);
        when(copy.isBorrowed()).thenReturn(false);
        when(copy.getIsbn()).thenReturn(1234);
        Set<Copy> copies = new HashSet<>();
        copies.add(copy);

        Book book = new Book(21, "book1", "author1", 2012, copies);

        BookDTO bookDTO = book.createDTO();

        assertEquals("book1", bookDTO.getName());
        assertEquals("author1", bookDTO.getAuthorName());
        assertEquals(2012, bookDTO.getYearPublished());
        assertEquals(1234, bookDTO.getIsbn());
    }

}
