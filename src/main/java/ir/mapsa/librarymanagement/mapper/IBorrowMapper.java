package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.BorrowQDto;
import ir.mapsa.librarymanagement.dto.BorrowSDto;
import ir.mapsa.librarymanagement.entity.Borrow;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBorrowMapper extends IBaseMapper<Borrow, BorrowQDto, BorrowSDto> {
}
