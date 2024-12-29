package top.nguyennd.blog.abstraction.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

@RestControllerAdvice
@Slf4j
public class ProblemHandler extends ResponseEntityExceptionHandler {

  static final String ERROR_MESSAGE = "Couldn't process request: %s";

  public static ProblemDetail asProblemDetail(final HttpStatus status,
                                              final String detail,
                                              final String type,
                                              final String title,
                                              Map<String, Object> properties
                                              ) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
    problemDetail.setType(URI.create(type));
    problemDetail.setTitle(title);
    if (nonNull(properties)) {
      problemDetail.setProperties(properties);
    }
    return problemDetail;
  }

  @ExceptionHandler(IllegalArgumentException.class)
  ProblemDetail handleBadRequests(final Exception exception) {
    logException(exception);
    return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
        format(ERROR_MESSAGE, exception.getMessage()));
  }

  private void logException(final Exception exception) {
    log.warn(format(ERROR_MESSAGE, exception.getMessage()));
  }


}
