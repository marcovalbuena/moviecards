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
        Movie[] movies = restTemplate.getForObject(serviceUrl + "/movies", Movie[].class);
        return Arrays.asList(movies != null ? movies : new Movie[0]);
    }

    @Override
    public Movie save(Movie movie) {
        try {
            return restTemplate.postForObject(serviceUrl + "/movies", movie, Movie.class);
        } catch (Exception e) {
            return movie;
        }
    }

    @Override
    public Movie getMovieById(Integer id) {
        return restTemplate.getForObject(serviceUrl + "/movies/" + id, Movie.class);
    }
}