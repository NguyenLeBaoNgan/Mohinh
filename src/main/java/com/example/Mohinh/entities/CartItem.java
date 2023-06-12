package com.example.Mohinh.entities;

import lombok.Data;

@Data
public class CartItem {
    private int idsp;
    private String tensp;
    private double price;
    private double soluong = 1;
}
