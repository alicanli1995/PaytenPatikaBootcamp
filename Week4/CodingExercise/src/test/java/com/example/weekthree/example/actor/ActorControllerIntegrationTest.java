package com.example.weekthree.example.actor;

import com.example.weekthree.controller.request.ActorCreateRequest;
import com.example.weekthree.controller.response.ActorCreateResponse;
import com.example.weekthree.dto.actor.ActorEntity;
import com.example.weekthree.dto.actor.ActorJpaDto;
import com.example.weekthree.example.BaseIntegrationTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class ActorControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    ActorJpaDto actorJpaRepository;

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_actor() {
        //given
        ActorCreateRequest request = new ActorCreateRequest();
        request.setActorName("test actor");
        request.setBirthDate(LocalDateTime.of(1990, 1, 12, 13, 0, 0)); //yükselenini hesaplamayacaksak saate gerek yok

        //when
        ResponseEntity<ActorCreateResponse> response = testRestTemplate.postForEntity("/actor", request, ActorCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        Optional<ActorEntity> actorEntity = actorJpaRepository.findById(response.getBody().getId());
        assertThat(actorEntity).isPresent();
        assertThat(actorEntity.get()).extracting("actorName", "birthDate")
                .containsExactly("test actor", LocalDateTime.of(1990, 1, 12, 13, 0, 0));
    }

}
