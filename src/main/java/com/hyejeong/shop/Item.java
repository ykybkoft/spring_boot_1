package com.hyejeong.shop;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.ToString;


@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 1000)
    public String title;
    public Integer price;




}
