package com.storages.example.web;

import static com.storages.example.utils.ExampleUtils.ADD_HOT_NEWS;

import com.storages.example.model.pg.News;
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
public class NewsController {

  private final ExampleService exampleService;

  @PostMapping(ADD_HOT_NEWS)
  public Map<String, String> addHotNews(@RequestBody News news) {
    log.info("addHotNews: request={}", news);

    exampleService.addHotNews(news);

    return Map.of("status", "ok");
  }

}
