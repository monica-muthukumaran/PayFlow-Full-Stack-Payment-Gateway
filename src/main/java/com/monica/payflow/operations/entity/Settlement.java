package com.monica.payflow.operations.entity;

import com.monica.payflow.common.entity.Money;
import com.monica.payflow.common.enums.SettlementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settlement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID merchantId;

    private Money grossAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "refund_amount_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "refund_currency"))
    })
    private Money refundAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "fee_amount_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "fee_currency"))
    })
    private Money feeAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gst_amount_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "gst_currency"))
    })
    private Money gstAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "net_amount_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "net_currency"))
    })
    private Money netAmount;

    @Enumerated(EnumType.STRING)
    private SettlementStatus status;

    private String bankReferenceNumber;

    private LocalDateTime processedAt;
}
