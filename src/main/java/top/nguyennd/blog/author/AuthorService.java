package top.nguyennd.blog.author;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.nguyennd.blog.abstraction.AbstractBaseService;
import top.nguyennd.blog.abstraction.exception.NotFoundException;

import java.util.UUID;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorService extends AbstractBaseService<Author> {

  AuthorRepository authorRepository;
  RedisTemplate<UUID, Object> redisTemplate;

  public AuthorService(AuthorRepository authorRepository,
                       RedisTemplate<UUID, Object> redisTemplate) {
    super(authorRepository, redisTemplate);
    this.authorRepository = authorRepository;
    this.redisTemplate = redisTemplate;
  }

  @Override
  public Class<Author> getEntityClass() {
    return Author.class;
  }

  public Author findInDbAndSetCache(UUID uuid) {
    var optionalAuthor = authorRepository.findById(uuid);
    if (optionalAuthor.isEmpty()) {
      setToRedis(uuid, "invalid");
      throw new NotFoundException(uuid);
    }
    var author = optionalAuthor.get();
    setToRedis(uuid, author);
    return author;
  }
}
