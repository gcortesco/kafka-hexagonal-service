package com.avoris.booking.reservation.searchservice.infrastructure.adapter.db;

import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;
import com.avoris.booking.reservation.searchservice.domain.port.repository.SearchReservationRepository;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.entity.SearchReservationEntity;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.repository.CustomSearchRepositoryDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;




@Component
public class SearchReservationRepositoryDb implements SearchReservationRepository {
    private static final Logger log = LoggerFactory.getLogger(SearchReservationRepositoryDb .class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    CustomSearchRepositoryDb searchRepositoryDb;
    @Override
    public CountSearchReservation getCountBySearchId(String searchId) {
        CountSearchReservation countSearchReservation = new CountSearchReservation();
        SearchReservationEntity searchReservation = searchRepositoryDb.findById(searchId).orElse(null);
        if (searchReservation != null){
            countSearchReservation.setSearchReservation(convert(searchReservation));
            Integer similarSearchRequest = searchRepositoryDb.findBySimilarSearch(searchReservation.getHotelId(),
                    searchReservation.getCheckin(), searchReservation.getCheckout());
            countSearchReservation.setCount(similarSearchRequest);

        }
        return countSearchReservation;
    }

    @Override
    public void save(SearchReservation searchReservation) throws Exception{
        SearchReservationEntity searchReservationEntity = mapToEntity(searchReservation);
        searchRepositoryDb.save(searchReservationEntity);
    }

    private SearchReservationDetails convert(SearchReservationEntity searchReservationEntity){
        SearchReservationDetails searchReservationDetails = new SearchReservationDetails();
        searchReservationDetails.setHotelId(searchReservationEntity.getHotelId());
        searchReservationDetails.setCheckIn(formatToString(searchReservationEntity.getCheckin()));
        searchReservationDetails.setCheckOut(formatToString(searchReservationEntity.getCheckout()));
        searchReservationDetails.setAges(searchReservationEntity.getAges());
        return searchReservationDetails;
    }

    private SearchReservationEntity mapToEntity(SearchReservation searchReservation) throws Exception{
        SearchReservationEntity searchReservationEntity = new SearchReservationEntity();
        searchReservationEntity.setSearchReservationId(searchReservation.getSearchId());
        searchReservationEntity.setHotelId(searchReservation.getSearchDetails().getHotelId());
        searchReservationEntity.setCheckin(formatToDate(searchReservation.getSearchDetails().getCheckIn()));
        searchReservationEntity.setCheckout(formatToDate(searchReservation.getSearchDetails().getCheckIn()));
        searchReservationEntity.setAges(searchReservation.getSearchDetails().getAges());
        return searchReservationEntity;
    }

    private java.sql.Date formatToDate(String date) throws Exception{
        return new java.sql.Date(dateFormat.parse(date).getTime());
    }

    private String formatToString( java.sql.Date date){
        return dateFormat.format(new Date(date.getTime()));
    }



}
