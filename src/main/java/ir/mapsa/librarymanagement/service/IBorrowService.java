package ir.mapsa.librarymanagement.service;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.IBaseService;
import ir.mapsa.librarymanagement.dto.BorrowQDto;
import ir.mapsa.librarymanagement.dto.BorrowSDto;

public interface IBorrowService extends IBaseService<BorrowQDto, BorrowSDto, Long> {

    public BorrowSDto giveBookTOMember(BorrowQDto borrowQDto) throws BaseException;

    public BorrowSDto returnBookFromMember(BorrowQDto borrowQDto) throws BaseException;
}
