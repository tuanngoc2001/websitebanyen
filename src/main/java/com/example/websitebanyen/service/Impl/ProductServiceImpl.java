package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.Product;
import com.example.websitebanyen.repository.ProductRepository;
import com.example.websitebanyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findAllByCategoryId(int id) {
        return repository.findAllByCategoryId(id);
    }

    @Override
    public Optional<Product> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return repository.findByTitleContaining(name);
    }

    @Override
    public List<Product> findAllByPriceDecrease() {
        return repository.findAllByPriceDec();
    }

    @Override
    public List<Product> findAllByPriceIncrease() {
        return repository.findAllByPriceIncr();
    }


    @Override
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAllByDateNew() {
        return repository.findAllByDateNew();
    }
}
