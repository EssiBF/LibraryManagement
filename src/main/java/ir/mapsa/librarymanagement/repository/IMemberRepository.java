package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends IBaseRepository<Member, Long> {

    Member findMemberByNationalCode (String nationalCode);
}

