package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MovieView;

public class CheckOutMovieCommand implements MenuCommand {
    private final MovieView movieView;
    private final Library library;

    public CheckOutMovieCommand(MovieView movieView, Library library) {
        this.movieView = movieView;
        this.library = library;
    }

    private void checkOutMovie(int movieId) {
        try {
            library.checkOutMovieCopy(movieId);
            movieView.printSuccessfulMovieCheckoutMessage();
        } catch (LibraryItemProcessingException e) {
            movieView.printUnSuccessfulMovieCheckoutMessage();
        }
    }

    @Override
    public void performCommand() throws Exception {
        int movieId = movieView.getMovieId();
        checkOutMovie(movieId);
    }
}
