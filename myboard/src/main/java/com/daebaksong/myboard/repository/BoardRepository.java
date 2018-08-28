package com.daebaksong.myboard.repository;

import com.daebaksong.myboard.domin.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public Page<Board> findAllBy(Pageable pageable);
    @Query(value = "select distinct b from Board b join fetch b.member order by b.id desc",
            countQuery = "select count(b) from Board b")
    public Page<Board> findAllByOrderByIdDesc(Pageable pageable);
    public Page<Board> findAllByTitleContains(String title, Pageable pageable);
    public Page<Board> findAllByContentContains(String content, Pageable pageable);
}
