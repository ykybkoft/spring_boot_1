package com.hyejeong.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepo;
    @GetMapping("/list")
    String list(Model model){


        List<Item> list = itemRepo.findAll();
        System.out.println();

        model.addAttribute("items",list);
        return "list.html";
    }

}
