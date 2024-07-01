package com.hyejeong.shop.item;

import com.hyejeong.shop.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
