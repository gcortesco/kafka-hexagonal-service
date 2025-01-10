package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.consumer;


import com.avoris.booking.reservation.searchservice.domain.port.kafka.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @Autowired
    KafkaConsumer kafkaConsumer;

    @KafkaListener( groupId = "${kafka.consumer.group}"
       //           , topicPartitions = { @TopicPartition(topic = "${kafka.consumer.topic}", partitions = { "0", "1", "2"})}
                  , topics = "${kafka.consumer.topic}"
                  , containerFactory = "kafkaListenerContainerFactory"
                  )
    public void listen1(String in) {
        logger.debug(in);
        kafkaConsumer.receiveMessage(in);
    }
}
