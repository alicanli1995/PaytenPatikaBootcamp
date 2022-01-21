package com.example.weekthree.dto.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface MemberJpaDto extends JpaRepository<MemberEntity, Long> {
}
