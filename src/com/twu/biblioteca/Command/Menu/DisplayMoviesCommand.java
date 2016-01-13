package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;

import java.util.Set;

public class DisplayMoviesCommand extends MenuCommand {
    private final MovieView movieView;
    private final Library library;

    public DisplayMoviesCommand(MovieView movieView, Library library, Set<Role> authorizedRoles) {
        super(authorizedRoles);
        this.movieView = movieView;
        this.library = library;
    }

    @Override
    public void performCommand(User user) throws Exception {
        movieView.printMovies(library.getListOfAvailableMovieDTO());
    }
}
