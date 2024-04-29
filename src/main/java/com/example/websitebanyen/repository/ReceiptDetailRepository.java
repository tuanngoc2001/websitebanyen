package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Integer> {
    Iterable<ReceiptDetail>findAllByReceipt_Id(int id);
}
