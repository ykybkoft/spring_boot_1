package com.hyejeong.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepo;

    private final MemberRepository mr;

    private final MemberService ms;

    private final ItemService is;

    private final BCryptPasswordEncoder bc;
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

//    @PostMapping("/add")
//    String writePost(@RequestParam Map<String, Object> formData) {
//        System.out.println(formData);
//        return "redirect:/list";
//    }

    @PostMapping("/add")
    String addPost(String title, Integer price){
        is.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){
        Optional<Item> row =itemRepo.findById(id);
        if(row.isPresent()){
            model.addAttribute("item",row.get());
            return "detail.html";

        }else{
            return "redirect:/list";
        }

    }

    @GetMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model){
        Optional<Item> item = is.selectItem(id);
        if(item.isPresent()){
            model.addAttribute("item",item.get());
            return "modify.html";
        }else{
            return "redirect:/list";
        }
    }

    @PostMapping("/modify")
    String modifyItem(String title, Integer price,Long id){

        is.modifyItem(title,price,id);




        return "redirect:/list";
    }

    @DeleteMapping("/item")
    ResponseEntity<String> delete(@RequestParam Long id){


        itemRepo.deleteById(id);
        return ResponseEntity.status(200).body("delete");
    }


    @GetMapping("/test")
    String test(){

        System.out.println(new BCryptPasswordEncoder().encode("ssss"));

        return "redirect:/list";
    }

    @GetMapping("/join")
    String join(){
        return "join.html";
    }

    @PostMapping("/member")
    String join1(@ModelAttribute Member member){

        member.setPassword(bc.encode(member.getPassword()));
        ms.saveMember(member);
        return "redirect:/list";
    }

}
