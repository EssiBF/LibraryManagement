package ir.mapsa.librarymanagement.base;

import ir.mapsa.librarymanagement.util.EntityCopyUtils;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public abstract class BaseService<E extends BaseEntity, QDto extends BaseDto, SDto extends BaseDto, ID extends Number>
        implements IBaseService<QDto, SDto, ID> {

    public IBaseRepository<E, ID> baseRepository;
    public IBaseMapper<E, QDto, SDto> baseMapper;


    @Override
    public SDto findById(ID id) throws BaseException {

        E entity = baseRepository
                .findById(id)
                .orElseThrow(() -> new BaseException("Requested Entity with id " + id + " not exists!"));
        if (entity.getDeleted()) throw new BaseException("Requested Entity Was Already Deleted!");
        return baseMapper.entityToRes(entity);
    }

    @Override
    public List<SDto> findAll() {

        List<E> entityList = baseRepository.findAll();
        List<SDto> SDtoList = new ArrayList<>();
        entityList.stream()
                .filter(entity -> !entity.getDeleted())
                .forEach(entity -> SDtoList.add(baseMapper.entityToRes(entity)));
        return SDtoList;
    }

    @Override
    public SDto create(QDto qDto) {

        //Convert Dto to Entity
        E entity = baseMapper.reqToEntity(qDto);
        //Completion
        entity.setDeleted(false);
        //Saving
        E returnedEntity = baseRepository.save(entity);
        //Convert Entity to Dto & Return
        return baseMapper.entityToRes(returnedEntity);
    }

    @Override
    public SDto update(QDto qDto) throws BaseException {
        //Convert Dto to Entity
        E entity = baseMapper.reqToEntity(qDto);
        //Get Current Entity From DB
        E currentEntity = baseRepository.findById((ID) entity.getId()).orElseThrow();
        if (entity.getDeleted()) throw new BaseException("Requested Entity Was Already Deleted!");
        //Update Non-Null Fields From Dto
        EntityCopyUtils.copyNonNullProperties(entity, currentEntity);
        //Saving
        E returnedEntity = baseRepository.save(currentEntity);
        //Convert Entity to Dto & Return
        return baseMapper.entityToRes(returnedEntity);
    }

    @Override
    public void deleteSafelyById(ID id) throws BaseException {

        E entity = baseRepository
                .findById(id)
                .orElseThrow(() -> new BaseException("Requested Entity with id " + id + " not exists!"));
        if (entity.getDeleted()) throw new BaseException("Requested Entity Was Already Deleted!");
        //Set safe delete
        entity.setDeleted(true);
        //Saving
        baseRepository.save(entity);
    }
}
