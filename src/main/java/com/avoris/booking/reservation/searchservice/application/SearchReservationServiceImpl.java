package com.avoris.booking.reservation.searchservice.application;

import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import com.avoris.booking.reservation.searchservice.domain.model.SearchReservationDetails;
import com.avoris.booking.reservation.searchservice.domain.port.kafka.producer.KafkaProducer;
import com.avoris.booking.reservation.searchservice.domain.port.service.SearchReservationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SearchReservationServiceImpl implements SearchReservationService {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public SearchReservationServiceImpl(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public  String registerSearchReservation(SearchReservationDetails searchReservationDetails){
        Gson gson = new Gson();
        SearchReservation searchReservation = new SearchReservation();
        String searchId = generateSearchId();
        searchReservation.setSearchId(searchId);
        searchReservation.setSearchDetails(searchReservationDetails);
        kafkaProducer.sendMessage(gson.toJson(searchReservation));
       return searchId;
    }

    private String generateSearchId(){
        return UUID.randomUUID().toString();
    }
}
