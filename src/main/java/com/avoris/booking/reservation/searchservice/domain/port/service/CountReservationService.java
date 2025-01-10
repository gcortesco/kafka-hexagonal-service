package com.avoris.booking.reservation.searchservice.domain.port.service;

import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;

public interface CountReservationService {
    CountSearchReservation countSearchReservation(String searchId);
}
