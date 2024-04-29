package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.ReceiptDetail;
import com.example.websitebanyen.repository.ReceiptDetailRepository;
import com.example.websitebanyen.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Autowired
    private ReceiptDetailRepository receiptDetailRepository;
    @Override
    public void save(ReceiptDetail receiptDetail) {
        receiptDetailRepository.save(receiptDetail);
    }

    @Override
    public Iterable<ReceiptDetail> findAllByReceiptId(int id) {
        return receiptDetailRepository.findAllByReceipt_Id(id);
    }
}
