package com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto;

import java.io.Serializable;

public class SearchDto implements Serializable {
    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    private String searchId;

}
