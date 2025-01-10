package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.producer;


import com.avoris.booking.reservation.searchservice.domain.port.kafka.producer.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerImpl implements KafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerImpl.class);
    @Autowired
    KafkaProducerDispatcher kafkaProducerDispatcher;

    @Override
    public void sendMessage(String message) {
        log.info("Message received kafka");
        try {
            kafkaProducerDispatcher.dispatch(message);
        }catch(Exception e){
            log.error("ERROR Sending Message KAFKA");
            log.error(e.getMessage());
            log.error(message);
            Thread.currentThread().interrupt();
        }
    }
}
