package com.storages.example.config.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
  private final String bootstrapServers;
  private final String groupId;
}
