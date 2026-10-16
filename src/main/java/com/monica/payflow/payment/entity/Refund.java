package com.monica.payflow.payment.entity;

import com.monica.payflow.common.entity.Money;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Embedded
    private Money amount;

    @Column(nullable = false)
    private String bankReferenceNumber;

    private String errorCode;

    private String errorDescription;

    private LocalDateTime processedAt;

    private LocalDateTime createdAt;

}
