package com.example.weekthree.models;


import com.example.weekthree.dto.actor.ActorEntity;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder

public class Actor implements Serializable {

    private Long id;
    private String actorName;
    private LocalDateTime birthDate;

    public ActorEntity convertToActorEntity(){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setActorName(actorName);
        actorEntity.setBirthDate(birthDate);
        return actorEntity;
    }


}
