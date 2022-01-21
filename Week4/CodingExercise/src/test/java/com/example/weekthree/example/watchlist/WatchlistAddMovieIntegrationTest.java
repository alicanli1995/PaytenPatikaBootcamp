package com.example.weekthree.example.watchlist;

import com.example.weekthree.controller.request.ModifyRequest;
import com.example.weekthree.controller.response.ModifyResponse;
import com.example.weekthree.controller.response.VoteCreateResponse;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.member.MemberJpaDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.movie.MovieJpaDto;
import com.example.weekthree.dto.vote.VoteEntity;
import com.example.weekthree.dto.watchlist.WatchListJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

 class WatchlistAddMovieIntegrationTest extends BaseIntegrationTest {

    @Autowired
    WatchListJpaDto watchListJpaDto;

    @Autowired
    MovieJpaDto movieJpaDto;

    @Autowired
    MemberJpaDto memberJpaDto;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/create-member.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/create-movie.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/create-watchlist.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_add_movie_with_watchlist_and_movie_in_db(){

//        given
        ModifyRequest modifyRequest = new ModifyRequest();
        modifyRequest.setMovieId(1L);
        modifyRequest.setWatchlistId(1L);

//         when
        ResponseEntity<ModifyResponse> response = testRestTemplate.postForEntity
                ("/watchlist/modify/add", modifyRequest, ModifyResponse.class);

//         then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

//       validate movie size
        List<MovieEntity> movieEntities = movieJpaDto.findAll();
        assertThat(movieEntities).hasSize(1);


//       validate member size
        List<MemberEntity> memberEntities = memberJpaDto.findAll();
        assertThat(memberEntities).hasSize(3);


    }


}
