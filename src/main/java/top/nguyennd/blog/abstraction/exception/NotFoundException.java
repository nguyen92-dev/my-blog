package top.nguyennd.blog.abstraction.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

import java.util.UUID;

import static top.nguyennd.blog.abstraction.exception.ProblemHandler.asProblemDetail;

@Slf4j
public class NotFoundException extends ErrorResponseException {
  private static final String NOT_FOUND = "Entity with identifier '%s' not found";
  private static final String TYPE = "/entity-not-found";

  public NotFoundException(final String identifier) {
    super(HttpStatus.NOT_FOUND,asProblemDetail(HttpStatus.NOT_FOUND, String.format(NOT_FOUND,identifier),
        TYPE,"Entity not found", null), null);
    log.error(String.format(NOT_FOUND, identifier));
  }

  public NotFoundException(UUID uuid) {
    this(uuid.toString());
  }
}
