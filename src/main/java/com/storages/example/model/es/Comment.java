package com.storages.example.model.es;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@Document(indexName = "comment")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Comment {

  @Id
  private long id;
  private long authorId;
  private long newsId;
  private String message;
}
