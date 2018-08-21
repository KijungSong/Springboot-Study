package com.daebaksong.myboard.service;

import com.daebaksong.myboard.domin.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void testGetBoards(){
        System.out.println("-------------------------");
        Page<Board> boards = boardService.getBoard(1);
        for (Board board: boards) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
        }
        System.out.println("-------------------------");
    }
}
