package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Movies.Movie;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class  LibraryTest {

    private List<Book> books;
    private List<Movie> movies;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        movies = new ArrayList<>();
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldCheckOutBookCopyWhenBookIsAvailable() throws LibraryItemProcessingException {
        int isbn = 2345;
        Book book = mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkOutBookCopy(isbn, null);
        verify(book).checkOutACopyByIsbn(isbn, null);
    }

    @Test
    public void shouldThrowExceptionWhenCheckOutBookCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Book book = mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkOutBookCopy(isbn, null);
    }

    @Test
    public void shouldCheckInBookCopyWhenBookIsBorrowed() throws LibraryItemProcessingException {
        int isbn = 2345;
        Book book = mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkInBookCopy(isbn, null);
        verify(book).checkInACopyByIsbn(isbn, null);
    }

    @Test
    public void shouldThrowExceptionWhenCheckInBookCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Book book = mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkInBookCopy(isbn, null);
    }

    @Test
    public void shouldCheckOutMovieCopyWhenMovieIsAvailable() throws LibraryItemProcessingException {
        int isbn = 2345;
        Movie movie = mock(Movie.class);
        when(movie.isIsbnOfThisItemType(isbn)).thenReturn(true);
        movies.add(movie);
        Library library = new Library(books, movies);
        library.checkOutMovieCopy(isbn, null);
        verify(movie).checkOutACopyByIsbn(isbn, null);
    }

    @Test
    public void shouldThrowExceptionWhenCheckOutMovieCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Movie movie = mock(Movie.class);
        when(movie.isIsbnOfThisItemType(isbn)).thenReturn(false);
        movies.add(movie);
        Library library = new Library(books, movies);
        library.checkOutBookCopy(isbn, null);
    }

    @Test
    public void shouldFindABookCopyByIsbn() throws Exception {
        int isbn = 1234;
        Copy copy = mock(Copy.class);
        Book book = mock(Book.class);
        books.add(book);
        when(book.findCopyByIsbn(isbn)).thenReturn(copy);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(true);
        Library library = new Library(books, movies);

        assertEquals(copy, library.findBookCopyByIsbn(isbn));
    }

    @Test
    public void shouldFindAMovieCopyByIsbn() throws Exception {
        int isbn = 1234;
        Copy copy = mock(Copy.class);
        Movie movie = mock(Movie.class);
        movies.add(movie);
        when(movie.findCopyByIsbn(isbn)).thenReturn(copy);
        when(movie.isIsbnOfThisItemType(isbn)).thenReturn(true);
        Library library = new Library(books, movies);

        assertEquals(copy, library.findMovieCopyByIsbn(isbn));
    }
}
