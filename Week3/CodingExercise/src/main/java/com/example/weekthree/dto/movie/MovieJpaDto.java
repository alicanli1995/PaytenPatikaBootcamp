package com.example.weekthree.dto.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaDto extends JpaRepository<MovieEntity, Long> {
}
