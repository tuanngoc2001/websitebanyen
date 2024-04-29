package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    Iterable<Receipt>findAllByUserIdAndStatus(int id,int status);
}
