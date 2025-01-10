
package com.avoris.booking.reservation.searchservice.domain.model;






public class CountSearchReservation {


    private String searchId;

    private SearchReservationDetails searchReservation;


    private Integer count;


    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public SearchReservationDetails getSearchReservation() {
        return searchReservation;
    }

    public void setSearchReservation(SearchReservationDetails searchReservation) {
        this.searchReservation = searchReservation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
