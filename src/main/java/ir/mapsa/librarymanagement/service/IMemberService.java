package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.MemberQDto;
import ir.mapsa.librarymanagement.dto.MemberSDto;

public interface IMemberService extends IBaseService<MemberQDto, MemberSDto, Long> {
    public MemberSDto findByNationalCode(String nationalCode) throws BaseException;
}
