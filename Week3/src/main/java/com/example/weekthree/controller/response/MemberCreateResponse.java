package com.example.weekthree.controller.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder


public class MemberCreateResponse {

    private Long memberId;


    public static MemberCreateResponse convertToMemberResponse(Long id) {
        return MemberCreateResponse.builder()
                .memberId(id)
                .build();
    }

}
