package com.monica.payflow.vault.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vault_card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaultCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private byte[] encryptedPan;

    @Column(nullable = false)
    private byte[] encryptedDeck;

    @Column(nullable = false, length = 4)
    private String lastFourDigits;

    @Column(nullable = false, length = 20)
    private String brand;

    @Column(nullable = false, length = 6)
    private String bin; // first 6 digits of the card number

    @Column(nullable = false, length = 2)
    private int expiryMonth;

    @Column(nullable = false, length = 4)
    private int expiryYear;

    @Column(length = 100)
    private String cardHolderName;

    private LocalDateTime deletedAt;
}
