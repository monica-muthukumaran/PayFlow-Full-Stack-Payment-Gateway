package com.monica.payflow.merchant.entity;

import com.monica.payflow.common.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.CUSTOMER;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

}
