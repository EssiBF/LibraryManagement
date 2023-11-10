package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Librarian;
import ir.mapsa.librarymanagement.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrarianRepository extends IBaseRepository<Librarian, Long> {

    Librarian findLibrarianByPerson (Person person);
    Librarian findLibrarianByPersonnelCode (String personnelCode);

}
