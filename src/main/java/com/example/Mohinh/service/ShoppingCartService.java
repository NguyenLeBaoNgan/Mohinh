package com.example.Mohinh.service;

import com.example.Mohinh.entities.CartItem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class ShoppingCartService implements IShoppingCartService{
    Map<Integer, CartItem> shoppingCart = new HashMap<>();
    @Override
    public void add(CartItem newItem){
        CartItem cartItem = shoppingCart.get(newItem.getIdsp());
        if(cartItem==null){
            shoppingCart.put(newItem.getIdsp(),newItem);
        }else {
            cartItem.setSoluong(cartItem.getSoluong()+1);
        }
    }
    @Override
    public void remove(int id){
        shoppingCart.remove(id);
    }

    @Override
    public CartItem update(int idsp, int soluong) {
        CartItem cartItem = shoppingCart.get(idsp);
        cartItem.setSoluong(soluong);
        return cartItem;
    }

    @Override
    public void clear() {
        shoppingCart.clear();
    }

    @Override
    public double getAmount() {
        return shoppingCart.values().stream()
                .mapToDouble(item-> item.getSoluong()*item.getPrice()).sum();
    }

    @Override
    public int getCount() {
        return shoppingCart.values().size();
    }

    @Override
    public Collection<CartItem> getAllItems() {
        return shoppingCart.values();
    }
}
