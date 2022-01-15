package com.example.weekthree.dto;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ModifyJpaDto extends JpaRepository<ModifyListEntity, Long> {

    ModifyListEntity findByMoviesIdAndWatchlistId(Long moviesId, Long watchlistId);
}
