package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Movies.Movie;
import com.twu.biblioteca.view.MovieView;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class  LibraryTest {

    private List<Book> books;
    private List<Movie> movies;
    private Set<Copy> copies;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        movies = new ArrayList<>();
        copies = new HashSet<>();
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void shouldCheckOutBookCopyWhenBookIsAvailable() throws LibraryItemProcessingException {
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkOutBookCopy(isbn);
        verify(book).checkOutACopyByIsbn(isbn);
    }

    @Test
    public void shouldThrowExceptionWhenCheckOutBookCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkOutBookCopy(isbn);
    }

    @Test
    public void shouldCheckInBookCopyWhenBookIsBorrowed() throws LibraryItemProcessingException {
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(true);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkInBookCopy(isbn);
        verify(book).checkInACopyByIsbn(isbn);
    }

    @Test
    public void shouldThrowExceptionWhenCheckInBookCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Book book = Mockito.mock(Book.class);
        when(book.isIsbnOfThisItemType(isbn)).thenReturn(false);
        books.add(book);
        Library library = new Library(books, new ArrayList<>());
        library.checkInBookCopy(isbn);
    }

    @Test
    public void shouldCheckOutMovieCopyWhenMovieIsAvailable() throws LibraryItemProcessingException {
        int isbn = 2345;
        Movie movie = Mockito.mock(Movie.class);
        when(movie.isIsbnOfThisItemType(isbn)).thenReturn(true);
        movies.add(movie);
        Library library = new Library(books, movies);
        library.checkOutMovieCopy(isbn);
        verify(movie).checkOutACopyByIsbn(isbn);
    }

    @Test
    public void shouldThrowExceptionWhenCheckOutMovieCopyIsUnAvailable() throws LibraryItemProcessingException {
        expected.expect(LibraryItemProcessingException.class);
        expected.expectMessage("Requested Item Copy UnAvailable");
        int isbn = 2345;
        Movie movie = Mockito.mock(Movie.class);
        when(movie.isIsbnOfThisItemType(isbn)).thenReturn(false);
        movies.add(movie);
        Library library = new Library(books, movies);
        library.checkOutBookCopy(isbn);
    }

}
