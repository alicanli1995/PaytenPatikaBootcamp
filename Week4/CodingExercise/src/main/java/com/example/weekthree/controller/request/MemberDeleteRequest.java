package com.example.weekthree.controller.request;


import com.example.weekthree.models.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class MemberDeleteRequest {

    @NotNull
    private Long memberId;

    public Member convertToDeleteMember() {
        return Member.builder()
                .build();
    }

}
