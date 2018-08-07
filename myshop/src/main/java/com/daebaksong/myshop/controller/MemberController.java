package com.daebaksong.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public String members(ModelMap modelMap){
        modelMap.addAttribute("count", 500);

        return "members"; // view name을 리턴한다.
    }
}
