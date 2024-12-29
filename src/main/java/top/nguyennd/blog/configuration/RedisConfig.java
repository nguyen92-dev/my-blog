package top.nguyennd.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.UUID;

@Configuration
public class RedisConfig {
  @Bean
  public RedisTemplate<UUID, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<UUID, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);
    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
    Jackson2JsonRedisSerializer<UUID> keySerializer = new Jackson2JsonRedisSerializer<>(UUID.class);

    template.setKeySerializer(keySerializer);
    template.setValueSerializer(serializer);

    template.setHashKeySerializer(keySerializer);
    template.setHashValueSerializer(serializer);
    return template;
  }
}
