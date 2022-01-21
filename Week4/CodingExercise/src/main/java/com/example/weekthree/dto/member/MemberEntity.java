package com.example.weekthree.dto.member;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "member")
@Table(name = "member")


public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer birthYear;

    @Column(nullable = false)
    private String mail;





}
