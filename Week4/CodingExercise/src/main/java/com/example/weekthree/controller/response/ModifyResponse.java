package com.example.weekthree.controller.response;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class ModifyResponse {
    private Long id;

    public static ModifyResponse convertToModifyResponse(Long id ){
        return ModifyResponse.builder()
                .id(id)
                .build();
    }
}
