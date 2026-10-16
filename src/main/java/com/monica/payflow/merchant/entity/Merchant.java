package com.monica.payflow.merchant.entity;

import com.monica.payflow.common.enums.BusinessType;
import com.monica.payflow.common.enums.MerchantStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Merchant {

    // 16 Digit unique Code
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "gst_id", nullable = false)
    private String gstId;

    @Column(name="pan",unique = true,nullable = false, length = 20)
    private String pan;

    @Column(length = 20)
    private String settlementBankAccountNumber;

    @Column(length = 11)
    private String settlementBankIfscCode;

    @Column(length = 100)
    private String settlementBankName;

    private String settlementBankAccountHolderName;

    @Column(length = 20)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private String businessName;

    private String websiteUrl;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MerchantStatus status = MerchantStatus.PENDING_KYC;

}
