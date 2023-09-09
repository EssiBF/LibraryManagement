package ir.mapsa.librarymanagement.controller;

import ir.mapsa.librarymanagement.base.BaseController;
import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.dto.MemberQDto;
import ir.mapsa.librarymanagement.dto.MemberSDto;
import ir.mapsa.librarymanagement.service.impl.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController extends BaseController<MemberQDto, MemberSDto, Long> {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        super(memberService);

        this.memberService = memberService;
    }

    @GetMapping("/nc")
    public ResponseEntity<MemberSDto> findByNationalCode(@RequestParam(name = "nationalCode") String nationalCode)
            throws BaseException {
        return new ResponseEntity<>(memberService.findByNationalCode(nationalCode), HttpStatus.OK);
    }
}
