package ir.mapsa.librarymanagement.service.impl;

import ir.mapsa.librarymanagement.base.BaseException;
import ir.mapsa.librarymanagement.base.BaseService;
import ir.mapsa.librarymanagement.dto.LibrarianQDto;
import ir.mapsa.librarymanagement.dto.LibrarianSDto;
import ir.mapsa.librarymanagement.entity.Librarian;
import ir.mapsa.librarymanagement.mapper.ILibrarianMapper;
import ir.mapsa.librarymanagement.repository.ILibrarianRepository;
import ir.mapsa.librarymanagement.service.ILibrarianService;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService extends BaseService<Librarian, LibrarianQDto, LibrarianSDto, Long>
implements ILibrarianService {

    private final ILibrarianRepository librarianRepository;
    private final ILibrarianMapper librarianMapper;

    public LibrarianService(ILibrarianRepository librarianRepository,
                            ILibrarianMapper librarianMapper) {
        super(librarianRepository, librarianMapper);

        this.librarianRepository = librarianRepository;
        this.librarianMapper = librarianMapper;
    }

    public LibrarianSDto findByNationalCode(String nationalCode) throws BaseException {

        Librarian targetLibrarian = librarianRepository.findLibrarianByNationalCode(nationalCode);
        if (targetLibrarian == null) throw new BaseException("Librarian national code is not found");
        return librarianMapper.entityToRes(targetLibrarian);
    }

    public LibrarianSDto findByPersonnelCode(String personnelCode) throws BaseException {

        Librarian targetLibrarian = librarianRepository.findLibrarianByPersonnelCode(personnelCode);
        if (targetLibrarian == null) throw new BaseException("Librarian personnel code is not found");
        return librarianMapper.entityToRes(targetLibrarian);
    }


}
