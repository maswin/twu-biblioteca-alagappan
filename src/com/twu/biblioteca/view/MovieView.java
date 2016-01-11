package com.twu.biblioteca.view;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;

import java.util.List;

public class MovieView {
    private final OutputWriter outputWriter;
    private final InputReader inputReader;

    public MovieView(OutputWriter outputWriter, InputReader inputReader) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void printMovies(List<MovieDTO> movies) {
        outputWriter.println("List Of Movies Available");
        outputWriter.println(String.format("%-12s %-25s %-20s %s %12s",
                "ISBN", "Movie Name", "Director Name", "Year", "Rating"));
        movies.forEach(movieDTO -> {
            String rating = getRatingString(movieDTO);
            outputWriter.println(String.format("%-12d %-25s %-20s %d %12s", movieDTO.getIsbn(),
                    movieDTO.getName(), movieDTO.getDirectorName(), movieDTO.getYear(), rating));
        });
    }

    private String getRatingString(MovieDTO movieDTO) {
        String rating;
        if(movieDTO.getRating() == null) {
            rating = "Unrated";
        } else {
            rating = String.valueOf(movieDTO.getRating());
        }
        return rating;
    }

    //TO DO
    public int getMovieId() {
        return 0;
    }

    //TO DO
    public void printSuccessfulMovieCheckoutMessage() {

    }

    //TO DO
    public void printUnSuccessfulMovieCheckoutMessage() {

    }
}
