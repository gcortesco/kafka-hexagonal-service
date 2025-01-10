package com.avoris.booking.reservation.searchservice.application.exception;

public class BusinessException extends RuntimeException {

    public static BusinessException buildByError(final SearchReservationErrorCode errorCode, final String errorMessage) {
        return new BusinessException(new BusinessError(errorCode, errorMessage));
    }

    private final transient BusinessError error;

    public BusinessException(BusinessError error) {
        super(error.getErrorMessage());
        this.error = error;
    }

    public BusinessError getError() {
        return error;
    }
}
