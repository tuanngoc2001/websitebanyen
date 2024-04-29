package com.example.websitebanyen.service;

import com.example.websitebanyen.model.Cart;

import java.util.List;

public interface CartService {
    void save(Cart cart);
    Iterable<Cart>getNumberCart(int id,int status);
    void deleteCart(int id);
    Cart findProductId(int productId,int userId);
    Cart findById(int id);
    List<Cart>findAllUserId(int id);
    List<Cart> checkProduct(int id);

    List<Cart>findAll();
}
