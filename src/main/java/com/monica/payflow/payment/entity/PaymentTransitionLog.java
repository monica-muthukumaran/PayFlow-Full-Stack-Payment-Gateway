package com.monica.payflow.payment.entity;

import com.monica.payflow.common.enums.PaymentActor;
import com.monica.payflow.common.enums.PaymentEvent;
import com.monica.payflow.common.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_log")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(nullable = false, length = 40)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private PaymentActor actor;

    @Column(nullable = false)
    private LocalDateTime occuredAt;
}
