package com.lauracercas.moviecards.unittest.controller;

import com.lauracercas.moviecards.controller.MovieController;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    @Mock
    private MovieService movieService;
    @Mock
    private Model model;

    @InjectMocks
    private MovieController movieController;

    @Test
    public void shouldReturnIndexViewWithMovies() {
        List<Movie> movies = new ArrayList<>();
        when(movieService.getAllMovies()).thenReturn(movies);

        String viewName = movieController.index(model);

        assertEquals("movies/list", viewName);
        verify(model).addAttribute("movies", movies);
    }

    @Test
    public void shouldReturnNewMovieView() {
        String viewName = movieController.create(model);
        assertEquals("movies/form", viewName);
        verify(model).addAttribute(any(String.class), any(Movie.class));
    }

    @Test
    public void shouldSaveMovieAndRedirect() {
        Movie movie = new Movie();
        String viewName = movieController.save(movie, model);
        assertEquals("redirect:/movies", viewName);
        verify(movieService).save(movie);
    }
}