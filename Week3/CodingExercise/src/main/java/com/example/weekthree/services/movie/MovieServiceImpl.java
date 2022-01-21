package com.example.weekthree.services.movie;


import com.example.weekthree.dto.actor.ActorDto;
import com.example.weekthree.dto.actor.ActorEntity;
import com.example.weekthree.dto.matching.MatchingDto;
import com.example.weekthree.dto.matching.MatchingEntity;
import com.example.weekthree.dto.movie.MovieDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.models.Actor;
import com.example.weekthree.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MovieServiceImpl implements MovieService {

    public final MovieDto movieDto;
    public final ActorDto actorDto;
    public final MatchingDto matchingDto;


    @Override
    @Transactional
    public Long create(Movie movie, List<Actor> actors, List<Long> actorIds){

        List<ActorEntity> existingActors = retriveExistingActors(actorIds);
        List<ActorEntity> createdActors = creatingActors(actors);
        MovieEntity movieEntity = movieDto.saveMovie(movie.convertToMovieEntity());

        ArrayList<ActorEntity> actorEntities = new ArrayList<>();

        actorEntities.addAll(existingActors);
        actorEntities.addAll(createdActors);

        List<MatchingEntity> matchingEntityList =actorEntities
                .stream().map(actorEntity -> {
                    MatchingEntity matchingEntity = new MatchingEntity();
                    matchingEntity.setActorEntity(actorEntity);
                    matchingEntity.setMovieEntity(movieEntity);
                    return matchingEntity;
                }).toList();
        matchingDto.saveMatching(matchingEntityList);
        return movieEntity.getId();

    }

    private List<ActorEntity> creatingActors(List<Actor> actors) {
        if (!CollectionUtils.isEmpty(actors)) {
            return actors.stream()
                    .map(Actor::convertToActorEntity)
                    .toList();
        }
        return new ArrayList<>();
    }

    private List<ActorEntity> retriveExistingActors(List<Long> actorIds) {
        if (!CollectionUtils.isEmpty(actorIds)) {
            List<ActorEntity> retrievedActors = actorDto.retrieve(actorIds);
            if (retrievedActors.size() < actorIds.size()) {
                throw new RuntimeException("Those ids cant found in database.");
            }
            return retrievedActors;
        }

        return new ArrayList<>();
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
                .toList();
    }

    @Override
    public List<Movie> retrieveAllV1(List<Long> getMoviesById) {
        return movieDto.retrieveAll(getMoviesById)
                .stream()
                .map(Movie::convertFromEntity)
                .toList();

    }
}
