package top.nguyennd.blog.abstraction.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

import java.util.Map;

import static top.nguyennd.blog.abstraction.exception.ProblemHandler.asProblemDetail;

@Slf4j
public class EntityConflictException extends ErrorResponseException {
  private static final String CONFLICT_MESSAGE = "The entity with %s already exists.";
  private static final String TYPE = "/conflict";

  public EntityConflictException(String identifier, Map<String, Object> conflicts) {
    super(HttpStatus.CONFLICT, asProblemDetail(HttpStatus.CONFLICT,
        String.format(CONFLICT_MESSAGE, identifier), TYPE, "Entity conflict", conflicts), null);
    log.error(String.format(CONFLICT_MESSAGE, identifier));
  }
}
