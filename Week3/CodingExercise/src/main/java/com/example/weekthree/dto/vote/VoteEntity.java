package com.example.weekthree.dto.vote;


import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity(name = "voteEntity")
@Table(name = "vote")

public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private Integer moviePoint;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity member;

}
