package com.example.weekthree.dto;

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
    @JoinColumn(nullable = false)
    private WatchlistEntity watchlistEntity;

    @Column(nullable = false)
    private Long moviesId;

    @Column(nullable = false)
    private Long watchlistId;

}
