package com.example.weekthree.dto.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor


public class ActorDtoImpl implements ActorDto{

    private final ActorJpaDto actorJpaDto;

    @Override
    public Long create(ActorEntity actorEntity) {
         ActorEntity finalEntity = actorJpaDto.save(actorEntity);
         return finalEntity.getId();
    }

    @Override
    public List<ActorEntity> retrieve(List<Long> actorIds) {
        return actorJpaDto.findAllByIdIn(actorIds);
    }
}
