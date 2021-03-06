package com.twu.biblioteca.model;

import com.twu.biblioteca.DTO.LibraryItemDTO;
import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.model.Books.Book;
import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Movies.Movie;
import com.twu.biblioteca.model.Users.User;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<Movie> movies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    private LibraryItem findItemByIsbn(int isbn, List<? extends LibraryItem> items) {
        Optional<? extends LibraryItem> foundItem = items.stream().filter(item -> item.isIsbnOfThisItemType(isbn)).findFirst();
        if(foundItem.isPresent()) {
            return foundItem.get();
        }
        return null;
    }

    private void checkOutItemCopy(int isbn, List<? extends LibraryItem> items, User user) throws LibraryItemProcessingException {
        LibraryItem item = findItemByIsbn(isbn, items);
        if(item != null) {
            item.checkOutACopyByIsbn(isbn, user);
        } else {
            throw new LibraryItemProcessingException("Requested Item Copy UnAvailable");
        }
    }

    public void checkOutBookCopy(int isbn, User user) throws LibraryItemProcessingException {
        checkOutItemCopy(isbn, books, user);
    }

    public void checkOutMovieCopy(int isbn, User user) throws LibraryItemProcessingException {
        checkOutItemCopy(isbn, movies, user);
    }

    private void checkInItemCopy(int isbn, List<? extends LibraryItem> items, User user) throws LibraryItemProcessingException {
        LibraryItem item = findItemByIsbn(isbn, items);
        if(item != null) {
            item.checkInACopyByIsbn(isbn, user);
        } else {
            throw new LibraryItemProcessingException("Requested Item Copy UnAvailable");
        }
    }

    public void checkInBookCopy(int isbn, User user) throws LibraryItemProcessingException {
        checkInItemCopy(isbn, books, user);
    }

    private <T extends LibraryItemDTO> List<T> getAvailableItems(List<? extends LibraryItem> items) {
        List<T> result = new ArrayList<>();
        items.stream().filter(LibraryItem::isAnyCopyAvailableUnBorrowed).forEach(item -> {
            try {
                T itemDTO = item.createDTO();
                result.add(itemDTO);
            } catch (LibraryItemProcessingException e) {
                e.printStackTrace();
            }
        });
        return result;
    }

    public List<BookDTO> getListOfAvailableBookDTO() throws LibraryItemProcessingException {
        return getAvailableItems(books);
    }

    public List<MovieDTO> getListOfAvailableMovieDTO() {
        return getAvailableItems(movies);
    }

    private Copy findItemCopyByIsbn(int isbn, List<? extends LibraryItem> items) throws LibraryItemProcessingException {
        LibraryItem item = findItemByIsbn(isbn, items);
        if(item == null) {
            throw new LibraryItemProcessingException("Requested Item Copy UnAvailable");
        }
        return item.findCopyByIsbn(isbn);
    }

    public Copy findBookCopyByIsbn(int isbn) throws LibraryItemProcessingException {
        return findItemCopyByIsbn(isbn, books);
    }

    public Copy findMovieCopyByIsbn(int isbn) throws LibraryItemProcessingException {
        return findItemCopyByIsbn(isbn, movies);
    }
}
