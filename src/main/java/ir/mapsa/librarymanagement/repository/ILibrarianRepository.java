package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Librarian;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrarianRepository extends IBaseRepository<Librarian, Long> {

    Librarian findLibrarianByNationalCode (String nationalCode);
    Librarian findLibrarianByPersonnelCode (String personnelCode);

}
