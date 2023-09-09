package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.PersonQDto;
import ir.mapsa.librarymanagement.dto.PersonSDto;
import ir.mapsa.librarymanagement.service.impl.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController extends BaseController<PersonQDto, PersonSDto, Long> {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        super(personService);
        this.personService = personService;
    }

    @GetMapping("/nc")
    public ResponseEntity<PersonSDto> findByNationalCode(@RequestParam(name = "nationalCode") String nationalCode)
            throws BaseException {
        return new ResponseEntity<>(personService.findByNationalCode(nationalCode), HttpStatus.OK);
    }


}
