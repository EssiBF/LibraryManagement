package ir.mapsa.librarymanagement.exception;

import ir.mapsa.librarymanagement.base.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorMessage> baseExceptionHandler(BaseException baseException) {

        ErrorMessage errorMessage = new ErrorMessage
                (HttpStatus.NOT_FOUND.value(), baseException.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
