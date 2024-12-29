package top.nguyennd.blog.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.nguyennd.blog.abstraction.BaseEntity;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "author")
@EqualsAndHashCode(callSuper = true)
@Data
public class Author extends BaseEntity implements Serializable {
  @Column(name = "user_name")
  private String userName;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "dob")
  private ZonedDateTime dob;
}
