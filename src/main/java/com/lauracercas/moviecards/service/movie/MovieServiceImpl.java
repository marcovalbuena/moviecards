package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.service.url}")
    private String serviceUrl;

    @Override
    public List<Movie> getAllMovies() {
        String url = serviceUrl + "/movies";
        Movie[] movies = restTemplate.getForObject(url, Movie[].class);
        return Arrays.asList(movies != null ? movies : new Movie[0]);
    }

    @Override
    public Movie save(Movie movie) {
        String url = serviceUrl + "/movies";
        return restTemplate.postForObject(url, movie, Movie.class);
    }

    @Override
    public Movie getMovieById(int movieId) {
        String url = serviceUrl + "/movies/" + movieId;
        return restTemplate.getForObject(url, Movie.class);
    }

    @Override
    public void deleteMovie(int movieId) {
        String url = serviceUrl + "/movies/" + movieId;
        restTemplate.delete(url);
    }
}