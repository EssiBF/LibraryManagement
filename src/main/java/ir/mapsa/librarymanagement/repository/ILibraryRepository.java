package ir.mapsa.librarymanagement.repository;

import ir.mapsa.librarymanagement.base.IBaseRepository;
import ir.mapsa.librarymanagement.entity.Library;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibraryRepository extends IBaseRepository<Library, Long> {

    List<Library> findLibraryByNameIsLikeIgnoreCase (String name);
}
