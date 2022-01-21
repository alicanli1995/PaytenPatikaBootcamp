package com.example.weekthree.controller.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class MemberCreateResponse {

    private Long memberId;


    public static MemberCreateResponse convertToMemberResponse(Long id) {
        return MemberCreateResponse.builder()
                .memberId(id)
                .build();
    }

}
