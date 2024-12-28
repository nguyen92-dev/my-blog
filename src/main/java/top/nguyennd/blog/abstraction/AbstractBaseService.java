package top.nguyennd.blog.abstraction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AbstractBaseService<V extends BaseEntity> {
  private final BaseRepository<V> repository;

  public AbstractBaseService(BaseRepository<V> repository) {
    this.repository = repository;
  }

  public V save(V entity) {
    return repository.save(entity);
  }

  public Optional<V> findById(UUID uuid) {
    return repository.findById(uuid);
  }

  public List<V> findAll() {
    return repository.findAll();
  }
}
