package com.example.weekthree.controller.request;

import com.example.weekthree.models.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class MemberCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer birthYear;

    @NotBlank
    private String mail;

    public Member convertToMember() {
        return Member.builder()
                .name(name)
                .birthYear(birthYear)
                .mail(mail)
                .build();
    }


}
