package ir.mapsa.librarymanagement.base;

import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IBaseController<QDto extends BaseDto, SDto extends BaseDto, ID extends Number> {

    //Gets
    public ResponseEntity<SDto> findById(ID id) throws BaseException;

    public ResponseEntity<List<SDto>> findAll();

    //Creating
    public ResponseEntity<SDto> create(QDto qDto);

    //Update
    public ResponseEntity<SDto> update(QDto qDto) throws BaseException;

    //Delete
    public ResponseEntity<Void> deleteSafelyById(ID id) throws BaseException;
}
