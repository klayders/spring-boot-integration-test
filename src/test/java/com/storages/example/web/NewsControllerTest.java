package com.storages.example.web;

import static com.storages.example.utils.ExampleUtils.ADD_HOT_NEWS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.storages.example.AbstractApplicationTests;
import com.storages.example.model.pg.News;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class NewsControllerTest extends AbstractApplicationTests {

  @Test
  @SneakyThrows
  void addNews() {
    var content = objectMapper.writeValueAsBytes(
        News.builder()
            .title("HOOOTT NEWS!!!!!")
            .description("read this NEWS!!!!!")
            .build()
    );

    mockMvc.perform(
        post(ADD_HOT_NEWS, "v1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                content
            )
    )
        .andExpect(status().isOk());

  }

}