package com.daebaksong.myboard.controller;

import com.daebaksong.myboard.domin.Board;
import com.daebaksong.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String boards(@RequestParam(name = "page", required = false, defaultValue = "1") int page, ModelMap modelMap) {

        Page<Board> boardPage = boardService.getBoard(page);
        modelMap.addAttribute("list",boardPage);
        return "list";
    }
}
