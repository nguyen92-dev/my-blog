package top.nguyennd.blog.abstraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import top.nguyennd.blog.abstraction.exception.NotFoundException;
import top.nguyennd.blog.author.Author;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseService<V extends BaseEntity> {
  private final BaseRepository<V> repository;
  private final RedisTemplate<UUID, Object> redisTemplate;
  private final ObjectMapper mapper;

  public AbstractBaseService(BaseRepository<V> repository, RedisTemplate<UUID, Object> redisTemplate, ObjectMapper mapper) {
    this.repository = repository;
    this.redisTemplate = redisTemplate;
    this.mapper = mapper;
  }

  @Transactional
  public V save(V entity) {
    return repository.save(entity);
  }

  @Transactional(readOnly = true)
  public Optional<V> findById(UUID uuid) {
    return repository.findById(uuid);
  }

  @Transactional(readOnly = true)
  public List<V> findAll() {
    return repository.findAll();
  }

  public abstract Class<V> getEntityClass();

  public V getFromRedis(UUID uuid) {
    if (!redisTemplate.hasKey(uuid)) {
      return null;
    }
    var value = redisTemplate.opsForValue().get(uuid);
    try {
      return mapper.convertValue(value, getEntityClass());
    } catch (IllegalArgumentException e) {
      throw new NotFoundException(uuid);
    }
  }

  public void setToRedis(UUID uuid, Object value) {
    redisTemplate.opsForValue().set(uuid, value, 30, TimeUnit.SECONDS);
  }
}
