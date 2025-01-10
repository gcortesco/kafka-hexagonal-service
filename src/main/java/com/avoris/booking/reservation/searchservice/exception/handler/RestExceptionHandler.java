package com.avoris.booking.reservation.searchservice.exception.handler;

import com.avoris.booking.reservation.searchservice.application.exception.BusinessError;
import com.avoris.booking.reservation.searchservice.application.exception.SearchReservationErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.avoris.booking.reservation.searchservice.application.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler  {

  private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler(value = BusinessException.class)
  public ResponseEntity<BusinessError> authorizationServiceExceptionHandler(HttpServletRequest req, BusinessException e) {
    logger.error("RestExceptionHandler BusinessException handler. Application error", e);
    return new ResponseEntity<>(e.getError(), e.getError().getStatus());
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<BusinessError> defaultErrorHandler(HttpServletRequest req, Exception e) {
    logger.error("RestExceptionHandler Exception handler. Application error", e);
    BusinessError error = new BusinessError(SearchReservationErrorCode.ERROR_00500, SearchReservationErrorCode.ERROR_00500.defaultMessage());
    return new ResponseEntity<>(error, error.getStatus());
  }

}
