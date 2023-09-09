package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long> {

    Person findPersonByNationalCode(String nationalCode);
}
