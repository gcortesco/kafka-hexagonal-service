package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.consumer;

import com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer.KafkaErrorProducer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Component
public class KafkaErrorProducerImpl implements KafkaErrorProducer {

    private final Logger logger = LoggerFactory.getLogger(KafkaErrorProducerImpl.class);

    private final KafkaTemplate<String, String> producerKafkaTemplate;
    private final String errorTopic;


    public KafkaErrorProducerImpl(final KafkaTemplate<String, String> producerKafkaTemplate,
                                  @Value("${kafka.consumer.dlq}") final String errorTopic){
        this.producerKafkaTemplate = producerKafkaTemplate;
        this.errorTopic = errorTopic;
    }

    public void sendErrorMessage(String message) throws ExecutionException {
        logger.info(String.format("Message sent to error Kafka -> %s", message));
        dispatch(message, errorTopic);
    }


    private boolean dispatch(String data, String topic) throws ExecutionException {
        try {
            this.producerKafkaTemplate.setDefaultTopic(topic);
            SendResult<String, String> sendResult = producerKafkaTemplate.sendDefault( data).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            logger.info("topic = {}, partition = {}, offset = {}, request = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(),
                    sendResult.getProducerRecord().value());
            return Boolean.TRUE;
        }catch (InterruptedException e) {
            logger.warn("Interrupted!", e);
            Thread.currentThread().interrupt();
            return Boolean.FALSE;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Boolean.FALSE;

        }
    }
}
