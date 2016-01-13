package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;

import java.util.Set;

public class CheckMovieStatusCommand extends MenuCommand {
    private final Library library;
    private final MovieView movieView;

    public CheckMovieStatusCommand(Library library, MovieView movieView, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.library = library;
        this.movieView = movieView;
    }

    @Override
    public void performCommand(User user) throws Exception {
        int isbn = movieView.getMovieId();
        try {
            Copy copy = library.findMovieCopyByIsbn(isbn);
            movieView.printMovieCopy(copy);
        } catch (LibraryItemProcessingException e) {
            movieView.printMovieCopyNotFound();
        }
    }
}
