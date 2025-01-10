package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.producer;

import java.util.concurrent.ExecutionException;

public interface KafkaProducerDispatcher {

    boolean dispatch(String data) throws ExecutionException;

}
