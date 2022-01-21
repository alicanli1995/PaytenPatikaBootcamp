package com.example.weekthree.dto.watchlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface WatchListJpaDto extends JpaRepository<WatchlistEntity, Long> {

    @Query(value = "select * from watchlist", nativeQuery = true)
    List<WatchlistEntity> findAllByWatchlist();


}
