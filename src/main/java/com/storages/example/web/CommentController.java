package com.storages.example.web;

import static com.storages.example.utils.ExampleUtils.ADD_COMMENT;

import com.storages.example.model.es.Comment;
import com.storages.example.services.ExampleService;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CommentController {

  private final ExampleService exampleService;

  @PostMapping(ADD_COMMENT)
  public Map<String, String> addComment(@RequestBody Comment comment){
    log.info("addComment: request={}", comment);

    exampleService.addCommentToNews(comment);

    return Map.of("status", "ok");
  }
}
