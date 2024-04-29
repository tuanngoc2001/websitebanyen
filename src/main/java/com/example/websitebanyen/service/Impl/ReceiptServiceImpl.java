package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.Receipt;
import com.example.websitebanyen.repository.ReceiptRepository;
import com.example.websitebanyen.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ReceiptRepository repository;


    @Override
    public Iterable<Receipt> findAllCart(int id,int status) {
        return repository.findAllByUserIdAndStatus(id,status);
    }

    @Override
    public void save(Receipt receipt) {
        repository.save(receipt);
    }
}
