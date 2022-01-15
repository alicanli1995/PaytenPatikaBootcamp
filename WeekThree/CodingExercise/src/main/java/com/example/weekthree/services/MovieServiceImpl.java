package com.example.weekthree.services;


import com.example.weekthree.dto.MovieDto;
import com.example.weekthree.dto.MovieEntity;
import com.example.weekthree.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MovieServiceImpl implements MovieService {

    public final MovieDto movieDto;

    @Override
    public Long create(Movie movie){
        MovieEntity movieEntity = movie.convertToMovieEntity();
        return movieDto.saveMovie(movieEntity);
    }

    @Override
    public Movie retrieve(Long id){
        MovieEntity movieEntity = movieDto.retrieve(id);
        return Movie.convertFromEntity(movieEntity);
    }

    @Override
    public void delete(Long id) {
         movieDto.delete(id);
    }

    @Override
    public List<Movie> getAllVoteMovies() {
        return movieDto.getAllVoteMovies()
                .stream()
                .map(Movie::convertFromEntity)
                .collect(Collectors.toList());
    }
}
