package ir.mapsa.librarymanagement.dto;

import ir.mapsa.librarymanagement.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowSDto extends BaseDto<Long> {

    private LocalDate dateOfIssue;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private BookSDto book;
    private MemberSDto member;

}
