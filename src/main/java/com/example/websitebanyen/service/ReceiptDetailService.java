package com.example.websitebanyen.service;

import com.example.websitebanyen.model.ReceiptDetail;

public interface ReceiptDetailService {
    void save(ReceiptDetail receiptDetail);
    Iterable<ReceiptDetail>findAllByReceiptId(int id);
}
