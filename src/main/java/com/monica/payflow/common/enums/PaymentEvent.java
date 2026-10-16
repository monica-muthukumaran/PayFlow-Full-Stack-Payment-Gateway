package com.monica.payflow.common.enums;

public enum PaymentEvent {
    AUTHORIZE_ATTEMPT,
    AUTHORIZE_SUCCESS,
    AUTHORIZE_FAIL,
    CAPTURE_REQUEST,
    CAPTURE_SUCCESS,
    CAPTURE_FAIL,
    REFUND_ATTEMPT,
    REFUND_SUCCESS,
    REFUND_FAILURE,
    SETTLE,
    CANCEL,
    CAPTURE_TIMEOUT

}
