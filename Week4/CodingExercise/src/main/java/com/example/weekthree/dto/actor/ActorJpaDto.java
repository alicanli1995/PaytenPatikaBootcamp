package com.example.weekthree.dto.actor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorJpaDto extends JpaRepository<ActorEntity, Long> {

    List<ActorEntity> findAllByIdIn(List<Long> actorIds);
}
