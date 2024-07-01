package com.hyejeong.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService ms;
    private final PasswordEncoder pe;


    @GetMapping("/join")
    String join(){
        return "join.html";
    }

    @PostMapping("/member")
    String join1(@ModelAttribute Member member){

        member.setPassword(pe.encode(member.getPassword()));
        ms.saveMember(member);
        return "redirect:/list";
    }
}
