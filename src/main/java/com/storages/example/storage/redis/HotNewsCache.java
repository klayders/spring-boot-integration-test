package com.storages.example.storage.redis;

import com.storages.example.model.pg.News;
import java.time.Duration;

public interface HotNewsCache {
  void saveHotNewsWithTTL(News news, Duration duration);

  Object findById(long newsId);
}
