package com.lauracercas.moviecards.unittest.model;

import com.lauracercas.moviecards.model.Movie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    @Test
    public void shouldSetAndGetId() {
        Movie movie = new Movie();
        movie.setId(1);
        assertEquals(1, movie.getId());
    }

    @Test
    public void shouldSetAndGetTitle() {
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        assertEquals("Test Movie", movie.getTitle());
    }
}