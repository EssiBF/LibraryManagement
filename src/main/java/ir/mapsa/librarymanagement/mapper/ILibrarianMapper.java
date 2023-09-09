package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.LibrarianQDto;
import ir.mapsa.librarymanagement.dto.LibrarianSDto;
import ir.mapsa.librarymanagement.entity.Librarian;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILibrarianMapper extends IBaseMapper<Librarian, LibrarianQDto, LibrarianSDto> {
}
