package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.BookQDto;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBookMapper extends IBaseMapper<Book, BookQDto, BookSDto> {

}
