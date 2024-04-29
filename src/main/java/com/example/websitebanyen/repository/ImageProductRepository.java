package com.example.websitebanyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageProductRepository extends JpaRepository<com.example.websitebanyen.model.ImageProduct, Long> {
}
