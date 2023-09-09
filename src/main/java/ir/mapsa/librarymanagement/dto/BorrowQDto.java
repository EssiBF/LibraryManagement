package ir.mapsa.librarymanagement.dto;

import ir.mapsa.librarymanagement.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowQDto extends BaseDto<Long> {

    private LocalDate dateOfIssue;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private BookQDto book;
    private MemberQDto member;

}
