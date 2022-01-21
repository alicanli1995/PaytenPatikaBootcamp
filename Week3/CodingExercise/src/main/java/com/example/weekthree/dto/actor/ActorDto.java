package com.example.weekthree.dto.actor;

import java.util.List;

public interface ActorDto {
    Long create(ActorEntity actorEntity);
    List<ActorEntity> retrieve(List<Long> actorIds);
}
