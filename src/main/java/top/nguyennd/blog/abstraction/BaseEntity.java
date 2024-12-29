package top.nguyennd.blog.abstraction;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  @CreatedDate
  @Column(updatable = false, name = "created_date")
  ZonedDateTime createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  ZonedDateTime lastModifiedDate;
}
