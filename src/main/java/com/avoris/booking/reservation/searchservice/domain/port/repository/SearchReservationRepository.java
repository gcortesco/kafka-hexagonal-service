package com.avoris.booking.reservation.searchservice.domain.port.repository;


import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import org.springframework.data.repository.query.Param;

public interface SearchReservationRepository  {
    public  CountSearchReservation getCountBySearchId(@Param("searchId") String searchId);

    public void save(SearchReservation searchReservation) throws Exception;

}
