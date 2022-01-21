package com.example.weekthree.models;


import com.example.weekthree.dto.member.MemberEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@EqualsAndHashCode

public class Member implements Serializable {


    private String name;
    private Integer birthYear;
    private String mail;

    public static Member convertFromEntity(MemberEntity memberEntity)
    {
        return Member.builder()
                .name(memberEntity.getName())
                .birthYear(memberEntity.getBirthYear())
                .mail(memberEntity.getMail())
                .build();
    }

    public MemberEntity convertToMovieEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(getName());
        memberEntity.setBirthYear(getBirthYear());
        memberEntity.setMail(getMail());
        return memberEntity;
    }
}
