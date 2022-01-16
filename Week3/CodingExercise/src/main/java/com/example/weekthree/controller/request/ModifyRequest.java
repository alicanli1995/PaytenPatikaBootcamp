package com.example.weekthree.controller.request;

import com.example.weekthree.models.ModifyList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ModifyRequest {

    private Long watchlistId;
    private Long movieId;

    public ModifyList convertToModify() {
        return ModifyList.builder()
                .watchListId(watchlistId)
                .movieId(movieId)
                .build();
    }
}
