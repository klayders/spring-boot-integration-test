package com.storages.example.storage.redis;

import com.storages.example.config.properties.RedisKeysProperties;
import com.storages.example.model.pg.News;
import java.time.Duration;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class HotNewsRedisRepository implements HotNewsCache {

  private final RedisKeysProperties redisKeysProperties;
  private final RedisTemplate<String, News> redisTemplate;

  @Override
  public void saveHotNewsWithTTL(News news, Duration duration) {
    var key = resolveKey(news.getId());
    redisTemplate.opsForValue().set(key, news);
    redisTemplate.expire(key, duration);
  }

  @Override
  public News findById(long newsId) {
    var key = resolveKey(newsId);
    return redisTemplate.opsForValue().get(key);
  }

  private String resolveKey(long newsId) {
    return redisKeysProperties.getNews() + newsId;
  }
}
