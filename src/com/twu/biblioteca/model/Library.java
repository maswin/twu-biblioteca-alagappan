package com.twu.biblioteca.model;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Movies.Movie;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<Movie> movies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    private Book findBookCopyByIsbn(int isbn) {
        Optional<Book> foundBook = books.stream().filter(book -> book.isIsbnOfThisItemType(isbn)).findFirst();
        if(foundBook.isPresent()) {
            return foundBook.get();
        }
        return null;
    }

    public void checkOutBookCopy(int isbn) throws LibraryItemProcessingException {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkOutACopyByIsbn(isbn);
        } else {
            throw new LibraryItemProcessingException("Requested Book Copy UnAvailable");
        }
    }

    public List<BookDTO> getListOfAvailableBookDTO() throws LibraryItemProcessingException {
        List<BookDTO> bookDTOs = new ArrayList<>();
        books.stream().filter(Book::isAnyCopyAvailableUnBorrowed).forEach(book -> {
            try {
                bookDTOs.add(book.createBookDTO());
            } catch (LibraryItemProcessingException e) {
                e.printStackTrace();
            }
        });
        return bookDTOs;
    }

    public void checkInBookCopy(int isbn) throws LibraryItemProcessingException {
        Book book = findBookCopyByIsbn(isbn);
        if(book != null) {
            book.checkInACopyByIsbn(isbn);
        } else {
            throw new LibraryItemProcessingException("Requested Book Copy UnAvailable");
        }
    }

    public List<MovieDTO> getListOfAvailableMovieDTO() {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        movies.stream().filter(Movie::isAnyCopyAvailableUnBorrowed).forEach(movie -> {
            try {
                movieDTOs.add(movie.createMovieDTO());
            } catch (LibraryItemProcessingException e) {
                e.printStackTrace();
            }
        });
        return movieDTOs;
    }
}
