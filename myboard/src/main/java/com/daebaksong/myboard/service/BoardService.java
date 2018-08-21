package com.daebaksong.myboard.service;

import com.daebaksong.myboard.domin.Board;

import java.util.List;

public interface BoardService {
    public Board addBoard(Long memberId, Board board);
    public List<Board> getBoard(int page);
}
