package com.storages.example.storage.es;

import com.storages.example.model.es.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends ElasticsearchRepository<Comment, Long> {
}
