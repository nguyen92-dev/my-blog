package top.nguyennd.blog.abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<V extends BaseEntity> extends JpaRepository<V, UUID> {

}
