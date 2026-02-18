package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie save(Movie movie);
    Movie getMovieById(int movieId);
    void deleteMovie(int movieId);
}