package com.monica.payflow.operations.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlement_payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SettlementPayment {

    @EmbeddedId
    private SettlementPaymentId id;

    @MapsId("settlementId")
    @ManyToOne
    @JoinColumn(name = "settlement_id", insertable = false, updatable = false)
    private Settlement settlement;
}
