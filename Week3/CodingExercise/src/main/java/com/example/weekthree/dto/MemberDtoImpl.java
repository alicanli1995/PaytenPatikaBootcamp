package com.example.weekthree.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberDtoImpl implements MemberDto{

    private final MemberJpaDto memberJpaDto;

    @Override
    public MemberEntity retrive(Long id) {
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
        return memberJpaDto.findAllByMembers();
    }

    @Override
    public void delete(Long id) {
        memberJpaDto.deleteById(id);
    }

}
