package com.example.websitebanyen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Receipt {
    //khi người dùng đặt hàng sẽ vào bảng này
    //status bawnfg2 là ng bán đã xác nhận đơn hàng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private User user;
    //mã hóa đơn nếu ng dùng thanh toán
    //còn k có thì nó chỉ là cart mà thôi

    private String sdt;

    private int status;
    private int number;

    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<ReceiptDetail> receiptDetailSet;

}
