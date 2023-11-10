package ir.mapsa.librarymanagement.dto;

import ir.mapsa.librarymanagement.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianQDto extends BaseDto<Long> {

    private String personnelCode;
    private LocalDate hireDate;
    private PersonQDto person;
}
