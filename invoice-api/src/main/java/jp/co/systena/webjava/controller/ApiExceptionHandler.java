package jp.co.systena.webjava.controller;

import jp.co.systena.webjava.beans.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
    ex.printStackTrace();
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(ErrorResponse.SYSTEM_ERROR);
    return super.handleExceptionInternal(
            ex,
            errorResponse,
            null,
            HttpStatus.INTERNAL_SERVER_ERROR,
            request
    );
  }
}