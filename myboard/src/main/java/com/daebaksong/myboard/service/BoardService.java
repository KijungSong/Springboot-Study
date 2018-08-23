package com.daebaksong.myboard.service;

import com.daebaksong.myboard.domin.Board;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {
    public Board addBoard(String email, Board board);
    public Page<Board> getBoard(int page);
}
