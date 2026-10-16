package com.monica.payflow.payment.entity;

import com.monica.payflow.common.entity.Money;
import com.monica.payflow.common.enums.OrderStatus;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "order_record")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // no foreign key relationship with Merchant entity, just storing the merchant's UUID
    // cross-service communication might be needed to fetch merchant details if required
    //@ManyToOne
    //@JoinColumn(name = "merchant_id")
    private UUID merchant;

    @Column(nullable = false, unique = true)
    private String idempotencyKey;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderStatus status = OrderStatus.CREATED;

    private String attempts;

    // convert json to map and vice versa using @JdbcTypeCode(SqlTypes.JSON)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> notes;

    private LocalDateTime expiresAt;

}
