package com.example.weekthree.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieJpaDto extends JpaRepository<MovieEntity, Long> {
    @Query(value = "select * from movie", nativeQuery = true)
    List<MovieEntity> findAllByMovie();
}
