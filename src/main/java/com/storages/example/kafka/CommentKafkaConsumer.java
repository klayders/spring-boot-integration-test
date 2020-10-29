package com.storages.example.kafka;

import static com.storages.example.utils.ExampleUtils.COMMENT_KAFKA_TOPIC;

import com.storages.example.model.es.Comment;
import com.storages.example.storage.es.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class CommentKafkaConsumer {

  private final CommentRepository commentRepository;


  @KafkaListener(topics = COMMENT_KAFKA_TOPIC)
  public void listener(Comment comment){
    log.info("listener: comment={}", comment );
    commentRepository.save(comment);
    log.info("listener: comment saved");
  }
}
