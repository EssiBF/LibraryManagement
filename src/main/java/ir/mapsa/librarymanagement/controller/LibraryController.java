package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibraryQDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;
import ir.mapsa.librarymanagement.service.ILibraryService;
import ir.mapsa.librarymanagement.service.impl.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController extends BaseController<LibraryQDto, LibrarySDto, Long> {

    private final ILibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        super(libraryService);
        this.libraryService = libraryService;
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<LibrarySDto>> findByName(@RequestParam(name = "name") String libName) {
        return new ResponseEntity<>(libraryService.findLibraryByName("%" + libName + "%"), HttpStatus.OK);
    }

    @GetMapping("/getAllBooks/{id}")
    public ResponseEntity<List<BookSDto>> getLibraryAllBooks(@PathVariable Long id)
            throws BaseException {
        return new ResponseEntity<>(libraryService.getLibraryAllBooks(id), HttpStatus.OK);
    }
}
