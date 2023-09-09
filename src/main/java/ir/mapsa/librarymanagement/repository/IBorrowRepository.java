package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Book;
import ir.mapsa.librarymanagement.entity.Borrow;
import ir.mapsa.librarymanagement.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBorrowRepository extends IBaseRepository<Borrow, Long> {

    List<Borrow> findBorrowsByBookAndReturnedDateIsNull(Book book);

    List<Borrow> findBorrowsByBookAndMemberAndReturnedDateIsNull(Book book, Member member);

}
