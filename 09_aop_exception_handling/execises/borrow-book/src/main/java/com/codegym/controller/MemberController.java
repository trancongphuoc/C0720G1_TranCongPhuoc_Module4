package com.codegym.controller;

import com.codegym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")
public class MemberController {


    @Autowired
    MemberService memberService;

    @GetMapping(value = "/manage")
    public String goManage(Model model) {
        model.addAttribute("memberList", memberService.findALl());

        return "view/member/manage";
    }
}
