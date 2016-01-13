package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;

import java.util.Set;

public class CheckOutMovieCommand extends MenuCommand {
    private final MovieView movieView;
    private final Library library;

    public CheckOutMovieCommand(MovieView movieView, Library library, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.movieView = movieView;
        this.library = library;
    }

    private void checkOutMovie(int movieId, User user) {
        try {
            library.checkOutMovieCopy(movieId, user);
            movieView.printSuccessfulMovieCheckoutMessage();
        } catch (LibraryItemProcessingException e) {
            movieView.printUnSuccessfulMovieCheckoutMessage();
        }
    }

    @Override
    public void performCommand(User user) throws Exception {
        int movieId = movieView.getMovieId();
        checkOutMovie(movieId, user);
    }
}
