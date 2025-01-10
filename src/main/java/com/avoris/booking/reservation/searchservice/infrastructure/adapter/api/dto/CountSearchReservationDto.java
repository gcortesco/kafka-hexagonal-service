package com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto;

import java.io.Serializable;

public class CountSearchReservationDto implements Serializable {
    private String searchId;

    private SearchDetailsDto searchDetailsDto;

    private Integer count;


    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public SearchDetailsDto getSearchDetailsDto() {
        return searchDetailsDto;
    }

    public void setSearchDetailsDto(SearchDetailsDto searchDetailsDto) {
        this.searchDetailsDto = searchDetailsDto;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
