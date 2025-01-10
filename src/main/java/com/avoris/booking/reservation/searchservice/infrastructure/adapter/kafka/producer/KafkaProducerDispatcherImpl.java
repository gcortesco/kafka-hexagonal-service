package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.producer;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;



@Service
public class KafkaProducerDispatcherImpl implements  KafkaProducerDispatcher{

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerDispatcherImpl.class);
    private final KafkaTemplate<String, String> producerKafkaTemplate;
    private final String topic;

    public KafkaProducerDispatcherImpl(final KafkaTemplate<String, String> producerKafkaTemplate,
                                       @Value("${kafka.producer.topic}") final String topic
    ){
        this.producerKafkaTemplate = producerKafkaTemplate;
        this.topic = topic;
    }


    @Override
    public boolean dispatch(String data) throws ExecutionException {
        try {
            producerKafkaTemplate.setDefaultTopic(topic);
            SendResult<String, String> sendResult = producerKafkaTemplate.sendDefault(data).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            log.info("topic = {}, partition = {}, offset = {}, request = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(),
                    sendResult.getProducerRecord().value());

            return Boolean.TRUE;
        }catch (InterruptedException e) {
            log.warn("Interrupted!", e);
            Thread.currentThread().interrupt();
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }

    }


}
