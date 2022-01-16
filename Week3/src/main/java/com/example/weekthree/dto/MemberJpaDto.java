package com.example.weekthree.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public interface MemberJpaDto extends JpaRepository<MemberEntity, Long> {

    @Query(value = "select * from member", nativeQuery = true)
    List<MemberEntity> findAllByMembers();
}
