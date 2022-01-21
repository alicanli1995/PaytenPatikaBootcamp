package com.example.weekthree.example.user;


import com.example.weekthree.controller.request.MemberDeleteRequest;
import com.example.weekthree.controller.response.MemberDeleteResponse;
import com.example.weekthree.dto.member.MemberJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

class MemberDeleteIntegrationTest  extends BaseIntegrationTest {


    @Autowired
    MemberJpaDto memberJpaDto;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/create-member.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_delete_member_in_db() {

        //given
        MemberDeleteRequest memberDeleteRequest = new MemberDeleteRequest();
        memberDeleteRequest.setMemberId(1L);

        //when

        ResponseEntity<MemberDeleteResponse> response = testRestTemplate.postForEntity
                ("/member",memberDeleteRequest,MemberDeleteResponse.class);


        //then

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getMemberId()).isNull();

    }


}
