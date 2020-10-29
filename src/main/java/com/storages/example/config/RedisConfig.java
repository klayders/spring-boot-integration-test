package com.storages.example.config;

import com.storages.example.config.properties.RedisProperties;
import com.storages.example.model.pg.News;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@AllArgsConstructor
public class RedisConfig {

  private final RedisProperties redisProperties;

  @Bean
  JedisConnectionFactory transferRedisConnectFactory() {
    var redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(redisProperties.getHost());
    redisStandaloneConfiguration.setPort(redisProperties.getPort());

    var jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
    jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
    jedisPoolConfig.setBlockWhenExhausted(false);

    return new JedisConnectionFactory(redisStandaloneConfiguration, JedisClientConfiguration.builder()
        .usePooling()
        .poolConfig(jedisPoolConfig)
        .build());
  }


  @Bean
  RedisTemplate<String, News> marathonRedisTemplate(JedisConnectionFactory transferRedisConnectFactory) {
    var redisTemplate = new RedisTemplate<String, News>();

    redisTemplate.setConnectionFactory(transferRedisConnectFactory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(News.class));

    return redisTemplate;
  }

}