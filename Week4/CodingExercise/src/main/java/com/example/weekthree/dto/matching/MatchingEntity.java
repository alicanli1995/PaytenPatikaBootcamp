package com.example.weekthree.dto.matching;


import com.example.weekthree.dto.actor.ActorEntity;
import com.example.weekthree.dto.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "matching")
@Table(name = "matching")

public class MatchingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MovieEntity movieEntity;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private ActorEntity actorEntity;


}
