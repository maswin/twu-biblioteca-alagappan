package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MovieView;

public class DisplayMoviesCommand implements MenuCommand {
    private final MovieView movieView;
    private final Library library;

    public DisplayMoviesCommand(MovieView movieView, Library library) {
        this.movieView = movieView;
        this.library = library;
    }

    @Override
    public void performCommand() throws Exception {
        movieView.printMovies(library.getListOfAvailableMovieDTO());
    }
}
