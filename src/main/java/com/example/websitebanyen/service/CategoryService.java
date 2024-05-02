package com.example.websitebanyen.service;

import com.example.websitebanyen.model.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(int id);
}
