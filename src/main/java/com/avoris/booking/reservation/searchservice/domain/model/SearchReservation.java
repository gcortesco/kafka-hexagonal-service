package com.avoris.booking.reservation.searchservice.domain.model;


public class SearchReservation {

    private String searchId;

    private SearchReservationDetails searchDetails;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public SearchReservationDetails getSearchDetails() {
        return searchDetails;
    }

    public void setSearchDetails(SearchReservationDetails searchDetails) {
        this.searchDetails = searchDetails;
    }

}
