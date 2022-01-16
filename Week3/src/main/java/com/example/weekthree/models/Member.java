package com.example.weekthree.models;


import com.example.weekthree.dto.MemberEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@EqualsAndHashCode

public class Member implements Serializable {

    private Long memberId;
    private String name;
    private Integer birthYear;
    private String mail;

    public static Member convertFromEntity(MemberEntity memberEntity)
    {
        return Member.builder()
                .memberId(memberEntity.getMemberId())
                .name(memberEntity.getName())
                .birthYear(memberEntity.getBirthYear())
                .mail(memberEntity.getMail())
                .build();
    }

    public MemberEntity convertToMovieEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(getMemberId());
        memberEntity.setName(getName());
        memberEntity.setBirthYear(getBirthYear());
        memberEntity.setMail(getMail());
        return memberEntity;
    }
}
