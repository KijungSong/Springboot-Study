package com.daebaksong.myboard.controller.api;

import com.daebaksong.myboard.domin.Board;
import com.daebaksong.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardApiController {
    @Autowired
    BoardService boardService;

    @GetMapping
    ResponseEntity<Page<Board>> boards(
        @RequestParam(name = "page", required = false, defaultValue = "1") int page){

        Page<Board> boardPage = boardService.getBoard(page);
        return new ResponseEntity<>(boardPage, HttpStatus.OK);
    }
}
