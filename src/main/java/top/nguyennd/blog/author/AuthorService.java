package top.nguyennd.blog.author;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import top.nguyennd.blog.abstraction.AbstractBaseService;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorService extends AbstractBaseService<Author> {

  AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    super(authorRepository);
    this.authorRepository = authorRepository;
  }
}
