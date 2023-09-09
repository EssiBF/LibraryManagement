package ir.mapsa.librarymanagement.exception;

import ir.mapsa.librarymanagement.base.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ErrorMessage> baseExceptionHandler(BaseException baseException) {
        return new ResponseEntity<>
                (new ErrorMessage(404, baseException.getMessage()), HttpStatus.NOT_FOUND);

    }
}
