package com.avoris.booking.reservation.searchservice.infrastructure.adapter.api;

import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;
import com.avoris.booking.reservation.searchservice.domain.port.service.CountReservationService;
import com.avoris.booking.reservation.searchservice.domain.port.service.SearchReservationService;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.controller.SearchReservationController;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.SearchDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = SearchReservationController.class)
public class SearchReservationControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private SearchReservationService searchReservationService;

    @MockBean
    private CountReservationService countReservationService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_return_count_search_reservation_response() throws Exception {

        when(countReservationService.countSearchReservation(anyString())).thenReturn(mockCountSearchReservation());

        MvcResult result =   mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/count")
                                .param("searchId","123456")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        assertEquals(result.getResponse().getStatus(), 200);
        assertNotNull(response);

    }

    @Test
    public void should_return_bad_request() throws Exception {

        SearchDetailsDto searchDetailsDto = new SearchDetailsDto();

        MvcResult result =   mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/search")
                                .content(mapper.writeValueAsString(searchDetailsDto))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        assertNotNull(response);
        assertEquals(result.getResponse().getStatus(), 400);


    }


    private CountSearchReservation mockCountSearchReservation(){
        CountSearchReservation countSearchReservation = new CountSearchReservation();
        countSearchReservation.setCount(Integer.parseInt("1"));
        countSearchReservation.setSearchId("123456");
        countSearchReservation.setSearchReservation(new SearchReservationDetails());
        return countSearchReservation;
    }
}
