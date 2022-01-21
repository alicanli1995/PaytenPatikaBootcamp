package com.example.weekthree.dto.modifylist;

import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.watchlist.WatchlistEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "modifylist-Entity")
@Table(name = "modify")

public class ModifyListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(nullable = false,name = "watchlistId")
    private WatchlistEntity watchlistEntity;

}
