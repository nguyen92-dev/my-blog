package top.nguyennd.blog.abstraction;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID uuid;

  @CreatedDate
  @Column(updatable = false, name = "created_date")
  ZonedDateTime createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  ZonedDateTime lastModifiedDate;
}
