package com.example.weekthree.controller.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class MemberDeleteResponse {
    private Long memberId;
    public static MemberDeleteResponse convertToMemberDeleteResponse(Long id) {
        return MemberDeleteResponse.builder()
                .memberId(id)
                .build();
    }
}
