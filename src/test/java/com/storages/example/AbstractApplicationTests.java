package com.storages.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@SpringJUnitWebConfig(
    initializers = AbstractApplicationTests.Initializer.class,
    classes = {ExampleApplication.class, TestConfiguration.class}
)
public abstract class AbstractApplicationTests {

  private static final Integer REDIS_PORT = 6379;

  @Autowired
  public MockMvc mockMvc;

  public static final ObjectMapper objectMapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Container
  private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:latest")
      .withDatabaseName("integration-tests-db")
      .withUsername("sample")
      .withPassword("sample");

  @Container
  private static final ElasticsearchContainer esContainer = new ElasticsearchContainer(
      "docker.elastic.co/elasticsearch/elasticsearch:7.9.3"
  );

  @Container
  private static final GenericContainer REDIS = new GenericContainer<>("redis:latest")
      .withExposedPorts(REDIS_PORT);

  @Container
  private static final KafkaContainer KAFKA = new KafkaContainer();


  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues
          .of(
              "spring.datasource.url=" + POSTGRE_SQL_CONTAINER.getJdbcUrl(),
              "spring.datasource.username=" + POSTGRE_SQL_CONTAINER.getUsername(),
              "spring.datasource.password=" + POSTGRE_SQL_CONTAINER.getPassword(),
              "spring.elasticsearch.rest.uris=" + esContainer.getHttpHostAddress(),
              "spring.kafka.bootstrap-servers=" + KAFKA.getBootstrapServers(),
              "app.redis.port=" + REDIS.getMappedPort(REDIS_PORT),
              "app.redis.host=" + REDIS.getContainerIpAddress()
          )
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }
}
