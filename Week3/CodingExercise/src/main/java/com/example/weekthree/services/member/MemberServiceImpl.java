package com.example.weekthree.services.member;

import com.example.weekthree.dto.member.MemberDto;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.models.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService {


    public final MemberDto memberDto;

    @Override
    public Long create(Member member) {
        MemberEntity memberEntity = member.convertToMovieEntity();
        return memberDto.saveMember(memberEntity);
    }

    @Override
    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache() {
        System.out.println("mySpecialCache is clearing now");
    }

    @Override
    @Cacheable(cacheNames = "mySpecialCache")
    public List<Member> getAllMembers() throws InterruptedException {
        Thread.sleep(2000);
        return memberDto.getAllMembers()
                .stream()
                .map(Member::convertFromEntity)
                .toList();
    }


    @Override
    public Long delete(Long id) {
        return memberDto.delete(id);
    }

}
