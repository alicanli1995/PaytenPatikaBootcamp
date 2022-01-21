package com.example.weekthree.dto.actor;


import com.example.weekthree.dto.matching.MatchingEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "actor")
@Table(name = "actor")

public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String actorName;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "actorEntity")
    private List<MatchingEntity> matchings;

}


