package com.example.weekthree.dto.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberDtoImpl implements MemberDto {

    private final MemberJpaDto memberJpaDto;

    @Override
    public MemberEntity retrieve(Long id) {
        Optional<MemberEntity> findMember = memberJpaDto.findById(id);
        if (findMember.isPresent())
            return findMember.get();
        else
            throw new RuntimeException();
    }

    @Override
    public Long saveMember(MemberEntity memberEntity) {
        MemberEntity savedEntity = memberJpaDto.save(memberEntity);
        return savedEntity.getMemberId();
    }

    @Override
    public List<MemberEntity> getAllMembers() {
        return memberJpaDto.findAll();
    }

    @Override
    public Long delete(Long id) {
        memberJpaDto.deleteById(id);
        return id;
    }

}
