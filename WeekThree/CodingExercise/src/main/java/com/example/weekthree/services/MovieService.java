package com.example.weekthree.services;

import com.example.weekthree.models.Movie;

import java.util.List;

public interface MovieService {
    Long create(Movie movie);
    Movie retrieve(Long id);
    void delete(Long id);
    List<Movie> getAllVoteMovies();
}
