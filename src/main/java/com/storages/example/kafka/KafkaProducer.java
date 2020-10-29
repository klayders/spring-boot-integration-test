package com.storages.example.kafka;

import static com.storages.example.utils.ExampleUtils.COMMENT_KAFKA_TOPIC;
import static com.storages.example.utils.ExampleUtils.NEWS_KAFKA_TOPIC;

import com.storages.example.model.es.Comment;
import com.storages.example.model.pg.News;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;


  public void sendComment(Comment comment) {
    kafkaTemplate.send(COMMENT_KAFKA_TOPIC, comment);
  }


  public void sendHotNews(News news) {
    kafkaTemplate.send(NEWS_KAFKA_TOPIC, news);
  }

}
