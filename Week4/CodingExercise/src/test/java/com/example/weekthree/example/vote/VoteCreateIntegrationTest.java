package com.example.weekthree.example.vote;


import com.example.weekthree.controller.request.VoteRequest;
import com.example.weekthree.controller.response.VoteCreateResponse;
import com.example.weekthree.dto.actor.ActorJpaDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.movie.MovieJpaDto;
import com.example.weekthree.dto.vote.VoteEntity;
import com.example.weekthree.dto.vote.VoteJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class VoteCreateIntegrationTest extends BaseIntegrationTest {

    @Autowired
    VoteJpaDto voteJpaDto;

    @Autowired
    MovieJpaDto movieJpaDto;

    @Autowired
    ActorJpaDto actorJpaDto;

    @Test
    @Sql(scripts = "/create-movie.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/create-member.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_vote_with_movie_in_db() {

        //given
        VoteRequest request = new VoteRequest();
        request.setMovieId(1L);
        request.setMemberId(1L);
        request.setMoviePoint(3);

//        when
        ResponseEntity<VoteCreateResponse> response = testRestTemplate.postForEntity
                ("/votes", request, VoteCreateResponse.class);

//        then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();


//       validate movie size
        List<MovieEntity> movieEntities = movieJpaDto.findAll();
        assertThat(movieEntities).hasSize(1);


//       validate vote size
        List<VoteEntity> voteEntities = voteJpaDto.findAll();
        assertThat(voteEntities).hasSize(1);

    }
}
