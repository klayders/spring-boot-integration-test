package com.storages.example.kafka;

import static com.storages.example.utils.ExampleUtils.NEWS_KAFKA_TOPIC;

import com.storages.example.model.pg.News;
import com.storages.example.storage.pg.NewsRepository;
import com.storages.example.storage.redis.HotNewsCache;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NewsKafkaConsumer {

  private final NewsRepository newsRepository;
  private final HotNewsCache cacheHotNews;

  @KafkaListener(topics = NEWS_KAFKA_TOPIC)
  public void listener(News news) {
    log.info("listener: news={}", news);
    var newsFromDB = newsRepository.save(news);
    cacheHotNews.saveHotNewsWithTTL(newsFromDB, Duration.ofMinutes(30));
    log.info("listener: news saved to db");

  }
}
