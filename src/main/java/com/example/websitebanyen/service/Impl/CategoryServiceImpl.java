package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.Category;
import com.example.websitebanyen.repository.CategoryRepository;
import com.example.websitebanyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }
}
