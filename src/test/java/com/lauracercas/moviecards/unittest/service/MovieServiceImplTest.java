package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class MovieServiceImplTest {

    @Mock
    private RestTemplate template;

    @InjectMocks
    private MovieServiceImpl sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldGetAllMovies() {
        Movie[] moviesArray = new Movie[2];
        moviesArray[0] = new Movie();
        moviesArray[1] = new Movie();

        when(template.getForObject(anyString(), eq(Movie[].class))).thenReturn(moviesArray);

        List<Movie> result = sut.getAllMovies();

        assertEquals(2, result.size());
    }

    @Test
    public void shouldGetMovieById() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Test Movie");

        when(template.getForObject(anyString(), eq(Movie.class))).thenReturn(movie);

        Movie result = sut.getMovieById(1);

        assertEquals("Test Movie", result.getTitle());
    }

    @Test
    public void shouldSaveMovie() {
        Movie movie = new Movie();
        movie.setTitle("New Movie");

        when(template.postForObject(anyString(), any(Movie.class), eq(Movie.class))).thenReturn(movie);

        Movie result = sut.save(movie);

        assertEquals("New Movie", result.getTitle());
    }
}