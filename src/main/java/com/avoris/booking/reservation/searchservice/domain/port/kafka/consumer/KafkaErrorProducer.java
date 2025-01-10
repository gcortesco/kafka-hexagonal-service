package com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer;

import java.util.concurrent.ExecutionException;

public interface KafkaErrorProducer {

    void sendErrorMessage(String message) throws ExecutionException;

}
