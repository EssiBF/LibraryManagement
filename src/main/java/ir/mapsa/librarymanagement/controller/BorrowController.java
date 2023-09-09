package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.BorrowQDto;
import ir.mapsa.librarymanagement.dto.BorrowSDto;
import ir.mapsa.librarymanagement.service.impl.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController extends BaseController<BorrowQDto, BorrowSDto, Long> {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        super(borrowService);
        this.borrowService = borrowService;
    }

    @PostMapping("/give")
    public ResponseEntity<BorrowSDto> giveBookToMember(@RequestBody BorrowQDto borrowQDto) throws BaseException {
        return new ResponseEntity<>(borrowService.giveBookTOMember(borrowQDto), HttpStatus.CREATED);
    }

    @PatchMapping("/return")
    public ResponseEntity<BorrowSDto> returnBookFromMember(@RequestBody BorrowQDto borrowQDto) throws BaseException {
        return new ResponseEntity<>(borrowService.returnBookFromMember(borrowQDto), HttpStatus.ACCEPTED);
    }

}
