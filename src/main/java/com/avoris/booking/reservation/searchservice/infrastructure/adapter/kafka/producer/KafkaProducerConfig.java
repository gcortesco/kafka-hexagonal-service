package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.producer;


import com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka.KafkaServerProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaProducerConfig<T>{

    @Bean

    public KafkaTemplate<String, T> producerKafkaTemplate(KafkaServerProperties kafkaProducerProperties) {
          return new KafkaTemplate<>(
                  new DefaultKafkaProducerFactory<>(
                          producerConfigs(kafkaProducerProperties)
                  )
          );
    }
    @Bean
    public Map<String, Object> producerConfigs(KafkaServerProperties kafkaProducerProperties) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getBootstrap());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kafkaProducerProperties.getIdempotence());
        props.put(ProducerConfig.ACKS_CONFIG, kafkaProducerProperties.getAcks());
        return props;
    }

}
