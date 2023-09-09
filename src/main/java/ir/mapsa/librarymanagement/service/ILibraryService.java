package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibraryQDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;

import java.util.List;

public interface ILibraryService extends IBaseService<LibraryQDto, LibrarySDto, Long> {

    public List<LibrarySDto> findLibraryByName(String name);

    public List<BookSDto> getLibraryAllBooks(Long id) throws BaseException;
}
