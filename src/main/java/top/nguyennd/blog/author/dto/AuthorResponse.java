package top.nguyennd.blog.author.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class AuthorResponse extends AuthorRequest {

  @JsonProperty
  UUID uuid;

  @JsonProperty
  ZonedDateTime createdAt;

  @JsonProperty
  ZonedDateTime lastModifiedAt;
}
