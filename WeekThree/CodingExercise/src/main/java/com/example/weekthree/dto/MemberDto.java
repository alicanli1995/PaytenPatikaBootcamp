package com.example.weekthree.dto;

import java.util.List;

public interface MemberDto {
    MemberEntity retrive(Long id);
    Long saveMember(MemberEntity memberEntity);
    List<MemberEntity> getAllMembers();
    void delete(Long id);
}
