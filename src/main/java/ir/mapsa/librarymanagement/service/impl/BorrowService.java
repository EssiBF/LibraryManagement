package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.BorrowQDto;
import ir.mapsa.librarymanagement.dto.BorrowSDto;
import ir.mapsa.librarymanagement.dto.MemberSDto;
import ir.mapsa.librarymanagement.entity.Borrow;
import ir.mapsa.librarymanagement.mapper.IBookMapper;
import ir.mapsa.librarymanagement.mapper.IBorrowMapper;
import ir.mapsa.librarymanagement.mapper.IMemberMapper;
import ir.mapsa.librarymanagement.repository.IBorrowRepository;
import ir.mapsa.librarymanagement.service.IBookService;
import ir.mapsa.librarymanagement.service.IBorrowService;
import ir.mapsa.librarymanagement.service.IMemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService extends BaseService<Borrow, BorrowQDto, BorrowSDto, Long>
        implements IBorrowService {

    private final IBorrowRepository borrowRepository;
    private final IBorrowMapper borrowMapper;
    private final IBookService bookService;
    private final IBookMapper bookMapper;
    private final IMemberService memberService;
    private final IMemberMapper memberMapper;

    public BorrowService(IBorrowRepository borrowRepository, IBorrowMapper borrowMapper,
                         IBookService bookService, IBookMapper bookMapper,
                         IMemberService memberService, IMemberMapper memberMapper) {
        super(borrowRepository, borrowMapper);

        this.borrowRepository = borrowRepository;
        this.borrowMapper = borrowMapper;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    public BorrowSDto giveBookTOMember(BorrowQDto borrowQDto) throws BaseException {

        //Member Validation
        MemberSDto memberSDto = memberService.findById(borrowQDto.getMember().getId());

        if (memberSDto.getDateOfExpiration().isBefore(LocalDate.now()))
            throw new BaseException("Your membership is expired!");

        //Book Validation
        BookSDto bookSDto = bookService.findById(borrowQDto.getBook().getId());

        List<Borrow> currentBorrowList = borrowRepository.
                findBorrowsByBookAndReturnedDateIsNull(bookMapper.reqToEntity(borrowQDto.getBook()));

        if (currentBorrowList.size() == 1) throw new BaseException("Sorry, The Book was issued!");

        //Completion, Creation, Return info
        borrowQDto.setDateOfIssue(LocalDate.now());
        borrowQDto.setDueDate(LocalDate.now().plusWeeks(1));
        borrowQDto.setReturnedDate(null);
        BorrowSDto borrowSDto = this.create(borrowQDto);
        borrowSDto.setBook(bookSDto);
        borrowSDto.setMember(memberSDto);
        return borrowSDto;

    }

    public BorrowSDto returnBookFromMember(BorrowQDto borrowQDto) throws BaseException {

        //Member Validation
        MemberSDto memberSDto = memberService.findById(borrowQDto.getMember().getId());

        //Book Validation
        BookSDto bookSDto = bookService.findById(borrowQDto.getBook().getId());

        List<Borrow> currentBorrowList = borrowRepository.findBorrowsByBookAndMemberAndReturnedDateIsNull
                (bookMapper.reqToEntity(borrowQDto.getBook()), memberMapper.reqToEntity(borrowQDto.getMember()));

        if (currentBorrowList.isEmpty())
            throw new BaseException("Sorry, The Book was not issued to this member or returned before!");

        //Update
        borrowQDto.setId(currentBorrowList.get(0).getId());
        borrowQDto.setReturnedDate(LocalDate.now());
        if (LocalDate.now().isAfter(currentBorrowList.get(0).getDueDate()))
            System.out.println("Member has " + LocalDate.now().compareTo(currentBorrowList.get(0).getDueDate()) + " days delay");
        BorrowSDto borrowSDto = this.update(borrowQDto);
        borrowSDto.setBook(bookSDto);
        borrowSDto.setMember(memberSDto);
        return borrowSDto;
    }

}
