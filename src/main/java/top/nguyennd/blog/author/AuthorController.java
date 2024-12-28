package top.nguyennd.blog.author;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.nguyennd.blog.author.dto.AuthorMapper;
import top.nguyennd.blog.author.dto.AuthorRequest;
import top.nguyennd.blog.author.dto.AuthorResponse;

import java.util.UUID;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController implements AuthorContract {

  AuthorMapper authorMapper;
  AuthorService authorService;

  public AuthorController(AuthorMapper authorMapper, AuthorService authorService) {
    this.authorMapper = authorMapper;
    this.authorService = authorService;
  }

  @Override
  public ResponseEntity<AuthorResponse> createAuthor(AuthorRequest authorRequest) {
    var author = authorMapper.toEntity(authorRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(authorMapper.toResponseDto(authorService.save(author)));
  }

  @Override
  public ResponseEntity<AuthorResponse> getAuthor(UUID uuid) {
    Author author = authorService.findById(uuid).orElse(null);
    return ResponseEntity.status(HttpStatus.OK).body(authorMapper.toResponseDto(author));
  }
}
