package com.example.weekthree.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


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
    private Long memberId;

    @Column(nullable = false)
    private Integer moviePoint;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity member;

}
