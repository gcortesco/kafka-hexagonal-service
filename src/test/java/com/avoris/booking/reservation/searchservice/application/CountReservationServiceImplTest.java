package com.avoris.booking.reservation.searchservice.application;

import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;
import com.avoris.booking.reservation.searchservice.domain.port.repository.SearchReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountReservationServiceImplTest {

    @InjectMocks
    private CountReservationServiceImpl countriesService;

    @Mock
    private SearchReservationRepository searchReservationRepository;

    @Test
    public void should_return_search_reservation(){
        when(searchReservationRepository.getCountBySearchId(anyString())).thenReturn(mockCountSearchReservation());

        CountSearchReservation countSearchReservation = countriesService.countSearchReservation("123456");

        assertNotNull(countSearchReservation);
        assertEquals(countSearchReservation.getSearchId(), "123456");
        assertEquals(countSearchReservation.getCount(), Integer.parseInt("1"));


    }

    private CountSearchReservation mockCountSearchReservation(){
        CountSearchReservation countSearchReservation = new CountSearchReservation();
        countSearchReservation.setSearchId("123456");
        countSearchReservation.setSearchReservation(new SearchReservationDetails());
        countSearchReservation.setCount(Integer.parseInt("1"));
        return countSearchReservation;
    }

}
