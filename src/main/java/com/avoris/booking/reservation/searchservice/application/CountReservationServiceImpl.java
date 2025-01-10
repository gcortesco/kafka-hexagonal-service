package com.avoris.booking.reservation.searchservice.application;

import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;

import com.avoris.booking.reservation.searchservice.domain.port.repository.SearchReservationRepository;
import com.avoris.booking.reservation.searchservice.domain.port.service.CountReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountReservationServiceImpl implements CountReservationService {

    private SearchReservationRepository searchReservationRepository;

    @Autowired
    public CountReservationServiceImpl( SearchReservationRepository searchReservationRepository) {
        this.searchReservationRepository = searchReservationRepository;
    }

    @Override
    public CountSearchReservation countSearchReservation(String searchId){
        return searchReservationRepository.getCountBySearchId(searchId);
    }


}
