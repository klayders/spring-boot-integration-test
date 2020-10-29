package com.storages.example.services;

import com.storages.example.kafka.KafkaProducer;
import com.storages.example.model.es.Comment;
import com.storages.example.model.pg.News;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExampleService {

  private final KafkaProducer kafkaProducer;

  public void addCommentToNews(Comment comment){
      kafkaProducer.sendComment(comment);
  }

  public void addHotNews(News news){
    kafkaProducer.sendHotNews(news);
  }
}
