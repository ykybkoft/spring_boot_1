package com.hyejeong.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/")
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "infoinfo";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "mypage";
    }




}
