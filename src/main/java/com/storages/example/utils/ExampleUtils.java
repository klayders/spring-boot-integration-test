package com.storages.example.utils;


public class ExampleUtils {

  public static final String COMMENT_KAFKA_TOPIC = "comment-topic";
  public static final String NEWS_KAFKA_TOPIC = "news-topic";

  private static final String EXAMPLE_API = "/api/{version}";


  private static final String COMMENT_API = EXAMPLE_API + "/comment";
  public static final String ADD_COMMENT = COMMENT_API + "/add";
  public static final String DELETE_COMMENT = COMMENT_API + "/delete";
  public static final String UPDATE_COMMENT = COMMENT_API + "/update";

  private static final String NEWS_API = EXAMPLE_API + "/news";
  public static final String ADD_HOT_NEWS = NEWS_API + "/hot/add";

}
