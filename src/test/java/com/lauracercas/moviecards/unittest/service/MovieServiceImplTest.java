package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        int result = sut.getAllMovies().size();

        assertEquals(2, result);
    }
}