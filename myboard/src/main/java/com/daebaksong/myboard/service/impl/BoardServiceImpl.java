package com.daebaksong.myboard.service.impl;

import com.daebaksong.myboard.domin.Board;
import com.daebaksong.myboard.domin.Member;
import com.daebaksong.myboard.repository.BoardRepository;
import com.daebaksong.myboard.repository.MemberRepository;
import com.daebaksong.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional
    public Board addBoard(Long memberId, Board board) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoard(int page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 3);
        Page<Board> boardPage = boardRepository.findAllByOrderByIdDesc(pageRequest);
        return boardPage;
    }
}
