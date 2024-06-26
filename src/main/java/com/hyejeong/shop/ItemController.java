package com.hyejeong.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepo;
    @GetMapping("/list")
    String list(Model model){


        List<Item> list = itemRepo.findAll();


        model.addAttribute("items",list);
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }



    @PostMapping("/add")
    String addPost(@RequestParam Map map){
        Item row = new Item();
        row.title=(String)map.get("title");
        row.price=Integer.parseInt((String) map.get("price")) ;
        itemRepo.save(row);

        return "redirect:/list";
    }

    @GetMapping("detail/{id}")
    String detail(@PathVariable Long id, Model model){
        Optional<Item> row =itemRepo.findById(id);
        if(row.isPresent()){
            model.addAttribute("item",row);
        }
        return "detail.html";
    }


}
