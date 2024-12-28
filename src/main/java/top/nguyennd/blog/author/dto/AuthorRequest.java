package top.nguyennd.blog.author.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import top.nguyennd.blog.abstraction.BaseViewModel;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AuthorRequest extends BaseViewModel {
  @JsonProperty
  private String userName;

  @JsonProperty
  private String fullName;

  @JsonProperty
  private ZonedDateTime dob;
}
