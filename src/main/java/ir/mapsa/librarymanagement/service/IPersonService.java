package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.PersonQDto;
import ir.mapsa.librarymanagement.dto.PersonSDto;

public interface IPersonService extends IBaseService<PersonQDto, PersonSDto, Long> {

    public PersonSDto findByNationalCode(String nationalCode) throws BaseException;

}
