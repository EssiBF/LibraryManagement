package ir.mapsa.librarymanagement.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto<ID> implements IBaseDto {

    protected ID id;
    protected LocalDateTime createdDate;
    protected LocalDateTime lastModifiedDate;
}
