package com.hyejeong.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepo;
    public void saveItem(String title,Integer price){
        Item row = new Item();
        row.setTitle(title);
        row.setPrice(price) ;
        itemRepo.save(row);
    }

    public Optional<Item> selectItem(Long id) {
        return itemRepo.findById(id);
    }

    public void modifyItem(String title, Integer price, Long id) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setId(id);

        itemRepo.save(item);
    }
}
