package com.example.Mohinh.service;

import com.example.Mohinh.entities.CartItem;

import java.util.Collection;

public interface IShoppingCartService {
    void add(CartItem newItem);
    void remove(int id);
    CartItem update(int idsp, int soluong);
    void clear();
    double getAmount();
    int getCount();
    Collection<CartItem> getAllItems();
}
