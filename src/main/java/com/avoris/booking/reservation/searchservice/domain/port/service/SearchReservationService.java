package com.avoris.booking.reservation.searchservice.domain.port.service;


import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;


public interface SearchReservationService {

    String registerSearchReservation(SearchReservationDetails searchReservationDetails);

}
