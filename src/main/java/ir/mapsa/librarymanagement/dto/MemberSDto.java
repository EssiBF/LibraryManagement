package ir.mapsa.librarymanagement.dto;

import ir.mapsa.librarymanagement.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSDto extends BaseDto<Long> {

    private String memberNo;
    private LocalDate dateOfMembership;
    private LocalDate dateOfExpiration;
    private PersonSDto person;
}
