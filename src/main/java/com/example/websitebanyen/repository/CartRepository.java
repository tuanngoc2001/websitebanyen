package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Iterable<Cart>findAllByUserIdAndStatus(int id,int status);
    List<Cart>findAllByUserId(int userId);
    void deleteById(int id);
    Cart findByProductIdAndUserId(int productId,int userId);
    Cart findById(int id);

    List<Cart> findAllByProductId(int id);
}
