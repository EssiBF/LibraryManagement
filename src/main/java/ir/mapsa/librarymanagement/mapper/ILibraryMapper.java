package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.LibraryQDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;
import ir.mapsa.librarymanagement.entity.Library;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILibraryMapper extends IBaseMapper<Library, LibraryQDto, LibrarySDto> {
}
