package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.BookQDto;
import ir.mapsa.librarymanagement.dto.BookSDto;
import ir.mapsa.librarymanagement.dto.LibrarySDto;
import ir.mapsa.librarymanagement.entity.Book;
import ir.mapsa.librarymanagement.entity.Library;
import ir.mapsa.librarymanagement.mapper.IBookMapper;
import ir.mapsa.librarymanagement.mapper.ILibraryMapper;
import ir.mapsa.librarymanagement.repository.IBookRepository;
import ir.mapsa.librarymanagement.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends BaseService<Book, BookQDto, BookSDto, Long> implements IBookService {

    private final IBookRepository bookRepository;
    private final IBookMapper bookMapper;
    private final ILibraryMapper libraryMapper;

    public BookService(IBookRepository bookRepository,
                       IBookMapper bookMapper,
                       ILibraryMapper libraryMapper) {

        super(bookRepository, bookMapper);

        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.libraryMapper = libraryMapper;
    }

    //1
    public List<BookSDto> findBookByTitle(String title) {
        List<Book> bookList = bookRepository.findBooksByTitleIsLikeIgnoreCaseOrderByTitle(title);
        List<BookSDto> bookSDtoList = new ArrayList<>();
        bookList.stream()
                .filter(book -> !book.getDeleted())
                .forEach(book -> bookSDtoList.add(bookMapper.entityToRes(book)));
        return bookSDtoList;
    }

    //2
    public LibrarySDto getBookLibrary(Long id) throws BaseException {

        Book bookEntity = bookRepository.findById(id).orElseThrow(BaseException::new);

        Library bookLibrary = bookEntity.getLibrary();
        return libraryMapper.entityToRes(bookLibrary);
    }

}
