package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.Cart;
import com.example.websitebanyen.repository.CartRepository;
import com.example.websitebanyen.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Iterable<Cart> getNumberCart(int id,int status) {
        return cartRepository.findAllByUserIdAndStatus(id,status);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart findProductId(int productId,int userId) {
        return cartRepository.findByProductIdAndUserId(productId,userId);
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> findAllUserId(int id) {
        return cartRepository.findAllByUserId(id);
    }

    @Override
    public List<Cart> checkProduct(int id) {
        return cartRepository.findAllByProductId(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }


}
