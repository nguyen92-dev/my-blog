package top.nguyennd.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {
  @Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);
    Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

    template.setKeySerializer(serializer);
    template.setValueSerializer(serializer);

    template.setHashKeySerializer(serializer);
    template.setHashValueSerializer(serializer);
    return template;
  }
}
