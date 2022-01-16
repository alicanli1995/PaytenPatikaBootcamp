package com.example.weekthree.controller.response;


import com.example.weekthree.models.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder

public class MemberResponse {

    private Long memberId;
    private String name;
    private Integer birthYear;
    private String mail;

    public static MemberResponse convertFrom(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .birthYear(member.getBirthYear())
                .mail(member.getMail())
                .build();
    }

    public static List<MemberResponse> convertFromMember(List<Member> memberList) {
        return memberList.stream()
                .map(MemberResponse::convertFrom)
                .collect(Collectors.toList());
    }
}
