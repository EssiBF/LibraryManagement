package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibraryQDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;
import ir.mapsa.librarymanagement.entity.Book;
import ir.mapsa.librarymanagement.entity.Library;
import ir.mapsa.librarymanagement.mapper.IBookMapper;
import ir.mapsa.librarymanagement.mapper.ILibraryMapper;
import ir.mapsa.librarymanagement.repository.ILibraryRepository;
import ir.mapsa.librarymanagement.service.ILibraryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService extends BaseService<Library, LibraryQDto, LibrarySDto, Long> implements ILibraryService {
    private final ILibraryRepository libraryRepository;
    private final ILibraryMapper libraryMapper;
    private final IBookMapper bookMapper;

    public LibraryService(ILibraryRepository libraryRepository,
                          ILibraryMapper libraryMapper,
                          IBookMapper bookMapper) {
        super(libraryRepository, libraryMapper);

        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
        this.bookMapper = bookMapper;
    }

    //1
    public List<LibrarySDto> findLibraryByName(String name) {

        List<Library> libraryList = libraryRepository.findLibraryByNameIsLikeIgnoreCase(name);
        List<LibrarySDto> libSDtoList = new ArrayList<>();
        libraryList.stream()
                .filter(library -> !library.getDeleted())
                .forEach(library -> libSDtoList.add((libraryMapper.entityToRes(library))));
        return libSDtoList;
    }

    //2
    public List<BookSDto> getLibraryAllBooks(Long id) throws BaseException {

        Library targetLibrary = libraryRepository.findById(id).orElseThrow(BaseException::new);
        List<Book> bookList = targetLibrary.getBookList();
        List<BookSDto> bookSDtoList = new ArrayList<>();
        bookList.stream()
                .filter(book -> !book.getDeleted())
                .forEach(book -> bookSDtoList.add(bookMapper.entityToRes(book)));
        return bookSDtoList;
    }

}
