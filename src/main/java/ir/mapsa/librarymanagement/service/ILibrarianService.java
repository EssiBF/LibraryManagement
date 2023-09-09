package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.LibrarianQDto;
import ir.mapsa.librarymanagement.dto.LibrarianSDto;

public interface ILibrarianService extends IBaseService<LibrarianQDto, LibrarianSDto, Long> {

    public LibrarianSDto findByNationalCode(String nationalCode) throws BaseException;

    public LibrarianSDto findByPersonnelCode(String personnelCode) throws BaseException;
}
