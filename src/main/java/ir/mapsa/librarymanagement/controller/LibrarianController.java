package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.LibrarianQDto;
import ir.mapsa.librarymanagement.dto.LibrarianSDto;
import ir.mapsa.librarymanagement.service.impl.LibrarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/librarians")
public class LibrarianController extends BaseController<LibrarianQDto, LibrarianSDto, Long> {

    private final LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        super(librarianService);
        this.librarianService = librarianService;
    }

    @GetMapping("/nc")
    public ResponseEntity<LibrarianSDto> findByNationalCode(@RequestParam(name = "nationalCode") String nationalCode)
            throws BaseException {
        return new ResponseEntity<>(librarianService.findByNationalCode(nationalCode), HttpStatus.OK);
    }

    @GetMapping("/pc")
    public ResponseEntity<LibrarianSDto> findByPersonnelCode(@RequestParam(name = "personnelCode") String personnelCode)
            throws BaseException {
        return new ResponseEntity<>(librarianService.findByPersonnelCode(personnelCode), HttpStatus.OK);
    }


}
