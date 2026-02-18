package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String index(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies/list";
    }

    @GetMapping("/movies/new")
    public String create(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/form";
    }

    @PostMapping("/movies/save")
    public String save(@ModelAttribute("movie") Movie movie, Model model) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String edit(@PathVariable("id") int movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movies/form";
    }
}