package com.example.weekthree.example.watchlist;

import com.example.weekthree.controller.request.WatchListRequest;
import com.example.weekthree.controller.response.WatchlistCreateResponse;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.member.MemberJpaDto;
import com.example.weekthree.dto.watchlist.WatchListJpaDto;
import com.example.weekthree.dto.watchlist.WatchlistEntity;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WatchlistCreateIntegrationTest extends BaseIntegrationTest {

    @Autowired
    WatchListJpaDto watchListJpaDto;

    @Autowired
    MemberJpaDto memberJpaDto;

    @Test
    @Sql(scripts = "/create-member.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_watchlist_with_member_in_db() {

        //given
        WatchListRequest request = new WatchListRequest();
        request.setMemberId(1L);
        request.setWatchListName("test-watchlist");

//        when
        ResponseEntity<WatchlistCreateResponse> response = testRestTemplate.postForEntity
                ("/watchlist/create", request, WatchlistCreateResponse.class);

//        then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

//       validate watchlist size
        List<WatchlistEntity> watchlistEntities = watchListJpaDto.findAll();
        assertThat(watchlistEntities).hasSize(1);

//       validate member size
        List<MemberEntity> memberEntities = memberJpaDto.findAll();
        assertThat(memberEntities).hasSize(3);

    }

}
