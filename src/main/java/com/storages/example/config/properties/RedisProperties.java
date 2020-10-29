package com.storages.example.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "app.redis")
public class RedisProperties {

  private String host;
  private int port;
  private int maxIdle;
  private int maxTotal;
}
