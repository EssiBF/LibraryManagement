package ir.mapsa.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianSDto extends PersonSDto {

    private String personnelCode;
    private String username;
    private String password;

}
