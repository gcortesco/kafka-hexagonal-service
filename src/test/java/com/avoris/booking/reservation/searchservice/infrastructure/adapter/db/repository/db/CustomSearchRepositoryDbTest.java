package com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.repository.db;

import com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.entity.SearchReservationEntity;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.db.repository.CustomSearchRepositoryDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class CustomSearchRepositoryDbTest {

    @Autowired
    private CustomSearchRepositoryDb repo;

    @Test
    void should_return_result_when_findById() {
        List<SearchReservationEntity> searchReservationEntities = repo.findAll();
        SearchReservationEntity  searchReservation = repo.findById("123456").orElse(null);

        assertNotNull(searchReservation);

    }

    void should_not_return_result_when_findById() {
        List<SearchReservationEntity> searchReservationEntities = repo.findAll();
        SearchReservationEntity  searchReservation = repo.findById("123457").orElse(null);

        assertNull(searchReservation);

    }

}
