
package com.avoris.booking.reservation.searchservice.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



public class SearchReservationDetails {

    private String hotelId;

    private String checkIn;

    private String checkOut;
    private List<Integer> ages;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public List<Integer> getAges() {
        return ages;
    }

    public void setAges(List<Integer> ages) {
        this.ages = ages;
    }


}
