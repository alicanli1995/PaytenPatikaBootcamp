package com.example.weekthree.dto.modifylist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public interface ModifyJpaDto extends JpaRepository<ModifyListEntity, Long> {
    ModifyListEntity findByMovieIdAndWatchlistEntityWatchListId(Long moviesId, Long watchlistId);
    List<ModifyListEntity> findAllByWatchlistEntityWatchListIdIsIn(Collection<Long> watchlistId);


    void deleteAllByMovieId(Long id);
}
