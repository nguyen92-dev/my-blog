package top.nguyennd.blog.author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.nguyennd.blog.author.dto.AuthorRequest;
import top.nguyennd.blog.author.dto.AuthorResponse;

import java.util.UUID;

public interface AuthorContract {

  @PostMapping
  ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest);

  @GetMapping("/unique-id/{uuid}")
  ResponseEntity<AuthorResponse> getAuthor(@PathVariable UUID uuid);
}
