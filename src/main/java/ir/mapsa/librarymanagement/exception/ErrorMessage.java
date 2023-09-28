package ir.mapsa.librarymanagement.exception;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private int code;
    private String message;
    private LocalDateTime localDateTime;

}
