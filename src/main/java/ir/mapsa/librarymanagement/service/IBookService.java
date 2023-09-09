package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.BookQDto;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;

import java.util.List;

public interface IBookService extends IBaseService<BookQDto, BookSDto,Long> {
    public List<BookSDto> findBookByTitle(String title);
    public LibrarySDto getBookLibrary(Long id) throws BaseException;
}
