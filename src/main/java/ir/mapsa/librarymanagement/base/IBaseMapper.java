package ir.mapsa.librarymanagement.base;

public interface IBaseMapper <E extends BaseEntity, QDto extends BaseDto, SDto extends BaseDto> {

    public E reqToEntity(QDto qDto);

    public SDto entityToRes(E entity);
}
