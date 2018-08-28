package com.daebaksong.myboard.controller;

import com.daebaksong.myboard.domin.Board;
import com.daebaksong.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

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

    @GetMapping("/writeform")
    public String writeform() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object p = authentication.getPrincipal();
        User user = (User)p;
        System.out.println("--------------------");
        System.out.println(p.getClass().getName());
        System.out.println("--------------------");

        return "writeform";
    }

    // Principal 객체는 로그인한 사용자의 id를 가지고 있다.
    @PostMapping
    public String boards(Principal principal, @ModelAttribute Board board) {
        board.setRegdate(LocalDateTime.now());
        boardService.addBoard(principal.getName(), board);

        return "redirect:boards";
    }

}
