package com.thesis.business.musicinstrument.order;

import java.time.LocalDate;

import com.thesis.business.musicinstrument.account.Account;
import com.thesis.business.musicinstrument.payment.Payment;

import jakarta.json.bind.annotation.JsonbDateFormat;
//import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @JsonbDateFormat(value = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "total")
    private Long total;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public CustomerOrder(Long id){
        this.id = id;
    }
}
