package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.PersonQDto;
import ir.mapsa.librarymanagement.dto.PersonSDto;
import ir.mapsa.librarymanagement.entity.Person;
import ir.mapsa.librarymanagement.mapper.IPersonMapper;
import ir.mapsa.librarymanagement.repository.IPersonRepository;
import ir.mapsa.librarymanagement.service.IPersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, PersonQDto, PersonSDto, Long>
implements IPersonService {

    private final IPersonRepository personRepository;
    private final IPersonMapper personMapper;

    public PersonService(IPersonRepository personRepository,
                         IPersonMapper personMapper) {
        super(personRepository, personMapper);

        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonSDto findByNationalCode(String nationalCode) throws BaseException {
        Person targetperson = personRepository.findPersonByNationalCode(nationalCode.trim());
        if (targetperson == null) throw new BaseException("National Code Not Found!");
        return personMapper.entityToRes(targetperson);
    }
}
