package com.avoris.booking.reservation.searchservice.application.exception;

import org.springframework.http.HttpStatus;

/**
 * Enum con los errores genericos del servicio del Sistema unificado de empleados
 * @author mpasut
 */
public enum SearchReservationErrorCode {
    ERROR_00400(HttpStatus.BAD_REQUEST),
    ERROR_00401(HttpStatus.UNAUTHORIZED),
    ERROR_00403(HttpStatus.FORBIDDEN),
    ERROR_00404(HttpStatus.NOT_FOUND),
    ERROR_00500(HttpStatus.INTERNAL_SERVER_ERROR);

    private HttpStatus status;
    private SearchReservationErrorCode(final HttpStatus status) {
        this.status = status;
    }

    /**
     * Código de error por cada item
     * @return El codigo SUE de error
     */
    public String defaultMessage() {
        if (this.equals(SearchReservationErrorCode.ERROR_00500)) return "unknown error";
        else if (this.equals(SearchReservationErrorCode.ERROR_00404)) return "not found";
        else if (this.equals(SearchReservationErrorCode.ERROR_00400)) return "bad request";
        return "";
    }
    public HttpStatus getStatus() {
        return status;
    }
}
