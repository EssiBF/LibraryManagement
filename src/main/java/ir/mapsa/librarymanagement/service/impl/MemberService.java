package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.MemberQDto;
import ir.mapsa.librarymanagement.dto.MemberSDto;
import ir.mapsa.librarymanagement.entity.Member;
import ir.mapsa.librarymanagement.entity.Person;
import ir.mapsa.librarymanagement.mapper.IMemberMapper;
import ir.mapsa.librarymanagement.repository.IMemberRepository;
import ir.mapsa.librarymanagement.repository.IPersonRepository;
import ir.mapsa.librarymanagement.service.IMemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends BaseService<Member, MemberQDto, MemberSDto, Long>
        implements IMemberService {

    private final IPersonRepository personRepository;
    private final IMemberRepository memberRepository;
    private final IMemberMapper memberMapper;

    public MemberService(IPersonRepository personRepository,
                         IMemberRepository memberRepository,
                         IMemberMapper memberMapper) {
        super(memberRepository, memberMapper);
        this.personRepository = personRepository;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberSDto findByNationalCode(String nationalCode) throws BaseException {
        Person targetPerson = personRepository.findPersonByNationalCode(nationalCode);
        Member targetMember = memberRepository.findMemberByPerson(targetPerson);
        if (targetMember == null) throw new BaseException("Member national code is not found");
        return memberMapper.entityToRes(targetMember);
    }


}
