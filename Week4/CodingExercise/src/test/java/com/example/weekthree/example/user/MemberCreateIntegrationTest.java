package com.example.weekthree.example.user;

import com.example.weekthree.controller.request.MemberCreateRequest;
import com.example.weekthree.controller.response.MemberCreateResponse;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.member.MemberJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemberCreateIntegrationTest extends BaseIntegrationTest {

    @Autowired
    MemberJpaDto memberJpaDto;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void should_create_user() {

        //given
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest();

        memberCreateRequest.setName("test-user11");
        memberCreateRequest.setMail("test-mail");
        memberCreateRequest.setBirthYear(2009);

        //when
        ResponseEntity<MemberCreateResponse> memberCreateResponse = testRestTemplate.postForEntity
                ("/member",memberCreateRequest,MemberCreateResponse.class);

        //then
        assertThat(memberCreateResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(memberCreateResponse.getBody()).isNotNull();
        assertThat(memberCreateResponse.getBody().getMemberId()).isNotNull();

        Optional<MemberEntity> actorEntity = memberJpaDto.findById(memberCreateResponse.getBody().getMemberId());
        assertThat(actorEntity).isPresent();
        assertThat(actorEntity.get()).extracting("name","mail","birthYear")
                .containsExactly("test-user11", "test-mail",2009);

    }

}
