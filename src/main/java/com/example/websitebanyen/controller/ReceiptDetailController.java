package com.example.websitebanyen.controller;

import com.example.websitebanyen.model.ReceiptDetail;
import com.example.websitebanyen.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/v1/receipt-details")
public class ReceiptDetailController {
    @Autowired
    private ReceiptDetailService receiptDetail;

    /**
     * lấy ra sản phẩm có trạng thái là thanh toán hoặc vận chuyển ra
     * @param id
     * @return
     */
    @GetMapping
    public ResponseEntity<Iterable<ReceiptDetail>> findAllByStatus(@RequestParam int id)
    {
        Iterable<ReceiptDetail> receipts=receiptDetail.findAllByReceiptId(id);
        if(receipts==null)
            return new ResponseEntity<>(receipts, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(receipts, HttpStatus.OK);
    }

    /**
     * thêm sản phẩm vào hóa đơn
     * @param receipt
     * @return
     */
    @PostMapping("/add-receipt")
    public ResponseEntity findAllByStatus(@RequestBody ReceiptDetail receipt)
    {
        receiptDetail.save(receipt);
        return new ResponseEntity(receipt,HttpStatus.OK);
    }
}
