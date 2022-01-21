package com.example.weekthree.dto.member;

import java.util.List;

public interface MemberDto {
    MemberEntity retrieve(Long id);
    Long saveMember(MemberEntity memberEntity);
    List<MemberEntity> getAllMembers();
    Long delete(Long id);
}
