package ir.mapsa.librarymanagement.base;

import java.util.List;

public interface IBaseService<QDto extends BaseDto, SDto extends BaseDto, ID extends Number> {

    public SDto findById(ID id) throws BaseException;

    public List<SDto> findAll();

    public SDto create(QDto qDto);

    public SDto update(QDto qDto) throws BaseException;

    public void deleteSafelyById(ID id) throws BaseException;

}
