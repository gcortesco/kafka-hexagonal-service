package com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.repository;

import com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.entity.SearchReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CustomSearchRepositoryDb extends JpaRepository<SearchReservationEntity, String> {
    @Query(value = """
        select count(*)
        from search_reservation
        where hotel_id = :hotelId
           and check_in = :checkin and check_out =:checkout""", nativeQuery = true)
    public Integer findBySimilarSearch(@Param("hotelId") String idDestination,
                                                             @Param("checkin") Date checkin,
                                                             @Param("checkout") Date checkout);
}
