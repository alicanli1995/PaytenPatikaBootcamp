package com.example.weekthree.dto;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteJpaDto extends JpaRepository<VoteEntity, Long> {
    @Query(value = "select * from vote", nativeQuery = true)
    List<VoteEntity> findAllByMovieId();


    //@Query(value = "SELECT * FROM rate WHERE movie_id = :movieId", nativeQuery = true)
    @Query(value = "Select r FROM voteEntity as r WHERE r.movie.id = :movieId")
    List<VoteEntity> retrieve(@Param("movieId") Long movieId);
}
