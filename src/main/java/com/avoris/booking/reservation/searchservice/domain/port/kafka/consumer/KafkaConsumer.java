package com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer;

public interface KafkaConsumer {

    void receiveMessage(String message);

}
