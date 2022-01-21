package com.example.weekthree.controller.request;


import com.example.weekthree.models.Actor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter

public class ActorCreateRequest {

    @NotBlank
    private String actorName;

    @NotNull
    private LocalDateTime birthDate;

    public Actor convertToActor(){
        return Actor.builder()
                .actorName(actorName)
                .birthDate(birthDate)
                .build();
    }

}
