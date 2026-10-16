package com.monica.payflow.common.enums;

public enum PaymentStatus {
    CREATED,
    AUTHORIZING,
    AUTHORIZED,
    CAPTURING,
    CAPTURED,
    SETTLED,
    FAILED,
    REFUNDED,
    CANCELLED,
    PARTIALLY_REFUNDED,
    AUTH_EXPIRED
}
