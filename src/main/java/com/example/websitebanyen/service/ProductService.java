package com.example.websitebanyen.service;

import com.example.websitebanyen.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findAllByCategoryId(int id);

    Optional<Product> findById(int id);

    List<Product> findAllByName(String name);

    List<Product>findAllByPriceDecrease();

    List<Product> findAllByPriceIncrease();

    void deleteProduct(int id);

    List<Product> findAllByDateNew();


}
