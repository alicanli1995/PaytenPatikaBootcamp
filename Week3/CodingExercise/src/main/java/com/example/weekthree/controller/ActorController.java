package com.example.weekthree.controller;


import com.example.weekthree.controller.request.ActorCreateRequest;
import com.example.weekthree.controller.response.ActorCreateResponse;
import com.example.weekthree.services.actor.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor

public class ActorController {

    private final ActorService actorService;

    @PostMapping("/actor")
    @ResponseStatus(HttpStatus.CREATED)
    public ActorCreateResponse createActor(@RequestBody @Valid ActorCreateRequest actorCreateRequest){
        Long createdActorId = actorService.create(actorCreateRequest.convertToActor());
        return ActorCreateResponse.builder().id(createdActorId).build();
    }

}
