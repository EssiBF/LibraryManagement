package ir.mapsa.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberQDto extends PersonQDto {

    private String memberNo;
    private LocalDate dateOfMembership;
    private LocalDate dateOfExpiration;

}
