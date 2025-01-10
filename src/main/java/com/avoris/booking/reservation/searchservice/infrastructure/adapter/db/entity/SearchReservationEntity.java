package com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import java.util.List;

@Entity
@Table(name = "search_reservation")
public class SearchReservationEntity implements Serializable {
    @Id
    @Column(name = "search_id",nullable = false)
    private String searchReservationId;


    @Column(name = "hotel_id")
    private String hotelId;

    @Column(name = "check_in")
    private Date checkin;

    @Column(name = "check_out")
    private Date checkout;

    @ElementCollection
    @CollectionTable(name = "ages_search")
    private List<Integer> ages;

    public String getSearchReservationId() {
        return searchReservationId;
    }

    public void setSearchReservationId(String searchReservationId) {
        this.searchReservationId = searchReservationId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public List<Integer> getAges() {
        return ages;
    }

    public void setAges(List<Integer> ages) {
        this.ages = ages;
    }





}
