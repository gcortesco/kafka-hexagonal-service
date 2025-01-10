package com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.mapper;


import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.CountSearchReservationDto;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.SearchDetailsDto;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.SearchDto;

public class SearchReservationMapper {

    public static CountSearchReservationDto convert(CountSearchReservation countSearchReservation){
        CountSearchReservationDto countSearchReservationDto = new CountSearchReservationDto();
        countSearchReservationDto.setSearchId(countSearchReservation.getSearchId());
        countSearchReservationDto.setSearchDetailsDto(convert(countSearchReservation.getSearchReservation()));
        countSearchReservationDto.setCount(countSearchReservation.getCount());
        return countSearchReservationDto;
    }

    public static SearchDetailsDto convert(SearchReservationDetails searchReservationDetails){
        SearchDetailsDto searchDetailsDto = new SearchDetailsDto();
        if (searchReservationDetails != null) {
            searchDetailsDto.setHotelId(searchReservationDetails.getHotelId());
            searchDetailsDto.setCheckIn(searchReservationDetails.getCheckIn());
            searchDetailsDto.setCheckOut(searchReservationDetails.getCheckOut());
            searchDetailsDto.setAges(searchReservationDetails.getAges());
        }
        return searchDetailsDto;
    }

    public static SearchReservationDetails convert(SearchDetailsDto searchDetailsDto){
        SearchReservationDetails searchReservationDetails = new SearchReservationDetails() ;
        searchReservationDetails.setHotelId(searchDetailsDto.getHotelId());
        searchReservationDetails.setCheckIn(searchDetailsDto.getCheckIn());
        searchReservationDetails.setCheckOut(searchDetailsDto.getCheckOut());
        searchReservationDetails.setAges(searchDetailsDto.getAges());
        return searchReservationDetails;
    }

    public static SearchDto convert(String searchId){
        SearchDto searchDto = new SearchDto();
        searchDto.setSearchId(searchId);
        return searchDto;
    }




}
