package com.monica.payflow.operations.entity;

import com.monica.payflow.common.enums.WebhookStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "webhook_events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WebhookEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID merchantId;

    @Column(nullable = false, length = 100)
    private String evetType;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private WebhookStatus event = WebhookStatus.PENDING;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> payload;

    @Column(nullable = false)
    private String targetUrl;

    @Column(nullable = false)
    private String signature;

    private Integer attempts;

    private LocalDateTime lastAttemptedAt;

    private LocalDateTime nextAttemptAt;

    private Integer lastResponseCode;

    private String lastResponseBody;

    private LocalDateTime deliveredAt;

}
