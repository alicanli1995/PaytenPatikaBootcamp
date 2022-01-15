package com.example.weekthree.services;

import com.example.weekthree.models.Member;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface MemberService {
    Long create(Member member);
    void clearCache();
    List<Member> getAllMembers() throws InterruptedException;
    void delete(Long id);
}
