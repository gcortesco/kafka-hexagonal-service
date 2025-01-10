package com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.controller;

import com.avoris.booking.reservation.searchservice.application.exception.BusinessError;
import com.avoris.booking.reservation.searchservice.application.exception.BusinessException;
import com.avoris.booking.reservation.searchservice.application.exception.ExceptionInvalidDataReceived;
import com.avoris.booking.reservation.searchservice.application.exception.SearchReservationErrorCode;
import com.avoris.booking.reservation.searchservice.domain.model.CountSearchReservation;
import com.avoris.booking.reservation.searchservice.domain.port.service.CountReservationService;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.CountSearchReservationDto;
import com.avoris.booking.reservation.searchservice.domain.port.service.SearchReservationService;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.SearchDetailsDto;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.dto.SearchDto;
import com.avoris.booking.reservation.searchservice.infrastructure.adapter.api.mapper.SearchReservationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class SearchReservationController {

    private final Logger logger = LoggerFactory.getLogger(SearchReservationController.class);

    @Autowired
    private SearchReservationService searchService;

    @Autowired
    private CountReservationService countReservationService;

    @GetMapping(path = "/count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CountSearchReservationDto> getCountSearch(@RequestParam(value = "searchId", required = false) String searchId) throws Exception {
        logger.info("Getting search  for id : {}", searchId);
        CountSearchReservation countReservation = countReservationService.countSearchReservation(searchId);
        if (Objects.isNull(countReservation.getSearchReservation())) throw new BusinessException(new BusinessError(SearchReservationErrorCode.ERROR_00404));
        return new ResponseEntity<>( SearchReservationMapper.convert(countReservation), HttpStatus.OK);
    }

    @PostMapping(path = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SearchDto> postSearch(@RequestBody final SearchDetailsDto searchDetailsDto) {
         logger.info("calling postSearch");
         validateSearch(searchDetailsDto);
         String reservationId = searchService.registerSearchReservation(SearchReservationMapper.convert(searchDetailsDto));
         return new ResponseEntity<>(SearchReservationMapper.convert(reservationId), HttpStatus.OK);
    }

    private void validateSearch(SearchDetailsDto searchDetailsDto){
        if (Objects.isNull(searchDetailsDto) || searchDetailsDto.getHotelId() == null || searchDetailsDto.getCheckIn() == null ||
                searchDetailsDto.getCheckOut() == null || searchDetailsDto.getAges() == null)
            throw new BusinessException(new BusinessError(SearchReservationErrorCode.ERROR_00400));
    }





}
