package com.daebaksong.myboard.repository;

import com.daebaksong.myboard.domin.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
