package com.example.weekthree.example.movie;

import com.example.weekthree.controller.request.ActorCreateRequest;
import com.example.weekthree.controller.request.MovieCreateRequest;
import com.example.weekthree.controller.response.MovieCreateResponse;
import com.example.weekthree.dto.actor.ActorEntity;
import com.example.weekthree.dto.actor.ActorJpaDto;
import com.example.weekthree.dto.matching.MatchingEntity;
import com.example.weekthree.dto.matching.MathingJpaDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.movie.MovieJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import com.example.weekthree.models.enums.GENRE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class MovieControllerTest extends BaseIntegrationTest {

    @Autowired
    MovieJpaDto movieJpaRepository;

    @Autowired
    ActorJpaDto actorJpaRepository;

    @Autowired
    MathingJpaDto matchingJpaRepository;

    @Test
    @Sql(scripts = "/actor-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_movie_with_actors_in_db_and_new_actors() {

        //given
        MovieCreateRequest request = new MovieCreateRequest();
        request.setName("test movie name");
        request.setGenre(GENRE.ACTION);
        request.setReleaseYear(2008);
        request.setDirector("test director");

        ActorCreateRequest actorCreateRequest1 = new ActorCreateRequest();
        actorCreateRequest1.setActorName("actor name 1");
        actorCreateRequest1.setBirthDate(LocalDateTime.of(2000, 1, 12, 14, 0));

        ActorCreateRequest actorCreateRequest2 = new ActorCreateRequest();
        actorCreateRequest2.setActorName("actor name 2");
        actorCreateRequest2.setBirthDate(LocalDateTime.of(1990, 1, 12, 14, 0));

        request.setActorList(List.of(actorCreateRequest1, actorCreateRequest2));
        request.setActorIds(List.of(1001L, 1002L, 1003L));

        //when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/movies", request, MovieCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        //validate movie
        Optional<MovieEntity> movie = movieJpaRepository.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get().getName()).isEqualTo("test movie name");
        //todo validate other movie fields

        //validate actor
        List<ActorEntity> actors = actorJpaRepository.findAll();
        assertThat(actors)
                .hasSize(5)
                .extracting("actorName", "birthDate")
                .contains(
                        tuple("actor name 1", LocalDateTime.of(2000, 1, 12, 14, 0)),
                        tuple("actor name 2", LocalDateTime.of(1990, 1, 12, 14, 0))
                );

        //validate matching
        List<MatchingEntity> matchings = matchingJpaRepository.findAll();
        assertThat(matchings).hasSize(5);
    }
}
