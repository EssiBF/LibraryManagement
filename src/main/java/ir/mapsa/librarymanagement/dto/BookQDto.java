package ir.mapsa.librarymanagement.dto;

import ir.mapsa.librarymanagement.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQDto extends BaseDto<Long> {

    private String title;
    private String author;
    private LibraryQDto library;
}
