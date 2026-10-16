package com.monica.payflow.merchant.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false)
    @URL
    private String targetUrl;

    private boolean enabled = true;

    @Column(nullable = false)
    private String eventType;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String webhookSecretHash;
}
