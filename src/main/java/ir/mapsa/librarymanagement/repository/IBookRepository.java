package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends IBaseRepository<Book, Long> {

    List<Book> findBooksByTitleIsLikeIgnoreCaseOrderByTitle (String title);
}
