package com.avoris.booking.reservation.searchservice.application;

import com.avoris.booking.reservation.searchservice.domain.model.SearchReservation;
import com.avoris.booking.reservation.searchservice.domain.port.repository.SearchReservationRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.avoris.booking.reservation.searchservice.application.exception.ExceptionInvalidDataReceived;

import com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer.KafkaConsumer;
import com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer.KafkaErrorProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SearchReservationReceiverConsumer implements KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(SearchReservationReceiverConsumer.class);

    private final String pattern = "dd-MM-yyyy";
    @Autowired
    SearchReservationRepository searchReservationRepository;

    @Autowired
    KafkaErrorProducer kafkaErrorProducer;

    @Override
    public void receiveMessage(String message) {
        log.info("Se ha recibido un nuevo mensaje de kafka");
        SearchReservation searchReservation;
        try {
            log.debug("Mensaje recibido");
            log.debug(message);
            Gson gson = new GsonBuilder().setDateFormat(pattern).create();
            searchReservation = gson.fromJson(message,   SearchReservation.class);
            searchMessageTreatment(searchReservation);
        }catch(ExceptionInvalidDataReceived e){
            log.error("Incorrect message");
            log.error(e.getMessage());
            log.error(e.getOriginalMessage());
            sendErrorMessageToKafka(message,e.getMessage(),"Incorrect message");
        }catch(Exception e){
            log.error("Error while processing message" );
            log.error(e.getMessage());
            log.error(message);
            sendErrorMessageToKafka(message,e.getMessage(),"Error while processing messageo");
        }
    }

    private void searchMessageTreatment(SearchReservation searchReservation) throws Exception {
        searchReservationRepository.save(searchReservation);
    }

    private void sendErrorMessageToKafka(String receivedMessage, String errorMessage, String extraInfo) {
        StringBuilder message = new StringBuilder();
        message.append("{");
        message.append(" \"original_message\" : ");
        message.append(receivedMessage);
        message.append(", \"error_message\": \"");
        message.append(errorMessage);
        message.append("\" ");
        message.append(", \"extra_info\": \"");
        message.append(extraInfo);
        message.append("\"");
        message.append("}");
        try {
            kafkaErrorProducer.sendErrorMessage(message.toString());
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }


}
