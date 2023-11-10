package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Member;
import ir.mapsa.librarymanagement.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends IBaseRepository<Member, Long> {

    Member findMemberByPerson (Person person);
}

