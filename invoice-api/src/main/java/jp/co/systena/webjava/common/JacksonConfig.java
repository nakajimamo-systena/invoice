package jp.co.systena.webjava.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * The Class JacksonConfig.
 */
@Configuration
public class JacksonConfig {

  /**
   * Object mapper.
   *
   * @return the object mapper
   */
  @Bean
  public ObjectMapper objectMapper() {
    return Jackson2ObjectMapperBuilder.json()
        .indentOutput(true)
        .build();
  }
}