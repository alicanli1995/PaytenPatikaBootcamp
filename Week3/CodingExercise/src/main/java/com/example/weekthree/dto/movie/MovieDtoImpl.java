package com.example.weekthree.dto.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MovieDtoImpl implements MovieDto{

    private final  MovieJpaDto movieJpaDto;

    @Override
    public MovieEntity saveMovie(MovieEntity movieEntity)
    {
        return movieJpaDto.save(movieEntity);
    }

    @Override
    public MovieEntity retrieve(Long id) {
        Optional<MovieEntity> findMovies = movieJpaDto.findById(id);
        if (findMovies.isPresent())
            return findMovies.get();
        else
            throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        movieJpaDto.deleteById(id);
    }

    @Override
    public List<MovieEntity> getAllVoteMovies() {
         return movieJpaDto.findAll();
    }

    @Override
    public List<MovieEntity> retrieveAll(List<Long> getMoviesById) {
        return movieJpaDto.findAllById(getMoviesById);
    }


}
