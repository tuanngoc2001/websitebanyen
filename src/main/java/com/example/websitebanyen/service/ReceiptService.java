package com.example.websitebanyen.service;

import com.example.websitebanyen.model.Receipt;

public interface ReceiptService {
    Iterable<Receipt>findAllCart(int id,int status);
    void save(Receipt receipt);
}
