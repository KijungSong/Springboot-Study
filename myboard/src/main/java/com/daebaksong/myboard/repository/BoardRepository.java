package com.daebaksong.myboard.repository;

import com.daebaksong.myboard.domin.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public Page<Board> findAllBy(Pageable pageable);
    public Page<Board> findAllByOrderByIdDesc(Pageable pageable);
    public Page<Board> findAllByTitleContains(String title, Pageable pageable);
    public Page<Board> findAllByContentContains(String content, Pageable pageable);
}
