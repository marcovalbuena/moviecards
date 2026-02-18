package com.lauracercas.moviecards.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private Integer id;
    private String title;
    private Integer year;
    private Integer duration;
    private String country;
    private String director;
    private String genre;
    private String synopsis;
    private String image;

    // Lista de actores que participan en la película
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    // --- MÉTODOS QUE FALTABAN (Los culpables del error) ---

    public void addActor(Actor actor) {
        if (this.actors == null) {
            this.actors = new ArrayList<>();
        }
        this.actors.add(actor);
    }

    public boolean existActorInMovie(Actor actor) {
        if (this.actors == null) {
            return false;
        }
        for (Actor a : this.actors) {
            if (a.getId() != null && a.getId().equals(actor.getId())) {
                return true;
            }
        }
        return false;
    }

    // --- GETTERS Y SETTERS ESTÁNDAR ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}