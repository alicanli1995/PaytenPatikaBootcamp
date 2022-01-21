package com.example.weekthree.dto.watchlist;

import com.example.weekthree.dto.member.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "watchlist")
@Table(name = "watchlist")


public class WatchlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchListId;

    @Column(nullable = false)
    private String watchListName;

    @ManyToOne
    @JoinColumn(nullable = false,name = "memberId")
    private MemberEntity memberEntity;

    @Column(nullable = false)
    private LocalDateTime createdDate;

}
