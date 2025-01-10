package com.avoris.booking.reservation.searchservice.domain.port.kafka.producer;

public interface KafkaProducer {


    void sendMessage(String message);
}
