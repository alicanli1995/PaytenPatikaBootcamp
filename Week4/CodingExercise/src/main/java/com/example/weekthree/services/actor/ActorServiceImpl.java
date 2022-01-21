package com.example.weekthree.services.actor;


import com.example.weekthree.dto.actor.ActorDto;
import com.example.weekthree.dto.actor.ActorEntity;
import com.example.weekthree.models.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ActorServiceImpl implements ActorService{

    private final ActorDto actorDto;


    @Override
    public Long create(Actor actor) {
        ActorEntity entity = actor.convertToActorEntity();
        return actorDto.create(entity);
    }
}
