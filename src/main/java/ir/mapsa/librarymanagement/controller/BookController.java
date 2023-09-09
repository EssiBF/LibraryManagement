package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.BookQDto;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;
import ir.mapsa.librarymanagement.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController extends BaseController<BookQDto, BookSDto, Long> {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        super(bookService);
        this.bookService = bookService;
    }


    @GetMapping("/findByTitle")
    public ResponseEntity<List<BookSDto>> findBookByTitle(@RequestParam(name = "title") String title) {
        return new ResponseEntity<>(bookService.findBookByTitle("%" + title + "%"), HttpStatus.OK);
    }

    @GetMapping("/getLibrary/{id}")
    public ResponseEntity<LibrarySDto> getBookLibrary(@PathVariable(name = "id") Long id)
            throws BaseException {
        return new ResponseEntity<>(bookService.getBookLibrary(id), HttpStatus.OK);
    }

}
