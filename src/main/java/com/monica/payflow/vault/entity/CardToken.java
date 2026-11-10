package com.monica.payflow.vault.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_token")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 40, unique = true)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vault_card_id")
    private VaultCard vaultCard;

    @Column(nullable = false)
    private UUID merchantId;

    @Column(nullable = false)
    private UUID customerId;

    private LocalDateTime revokedAt;

}
