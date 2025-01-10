package com.avoris.booking.reservation.searchservice.application.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;




public class BusinessError {
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_message")
    private String errorMessage;

    @JsonIgnore
    private HttpStatus status;

    /**
     * Constructor por defecto, ambos parametros son obligatoios
     * @param errorCode Código wedding de error
     * @param errorMessage Mensaje del error
     * @param status Http status
     */
    public BusinessError(final String errorCode, final String errorMessage, final HttpStatus status ) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    /**
     * Constructor que recibe el enum WeddingApiErrorCode, en este caso se toman los codigos y mensajes de error por defecto del enum
     * @param error Enum con los valores por defecto para errorCode ,errorMessage y status
     */
    public BusinessError(final SearchReservationErrorCode error, final String errorMessage) {
        this(error.name(), errorMessage, error.getStatus());
    }

    /**
     * Constructor que recibe el enum WeddingApiErrorCode, en este caso se toman los codigos y mensajes de error por defecto del enum
     * @param error Enum con los valores por defecto para errorCode y errorMessage
     */
    public BusinessError(final SearchReservationErrorCode error) {
        this(error.name(), error.defaultMessage(), error.getStatus());
    }
}
