package ir.mapsa.librarymanagement.base;

import ir.mapsa.librarymanagement.util.EntityCopyUtils;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BaseService<E extends BaseEntity, QDto extends BaseDto, SDto extends BaseDto, ID extends Number>
        implements IBaseService<QDto, SDto, ID> {

    public IBaseRepository<E, ID> baseRepository;
    public IBaseMapper<E, QDto, SDto> baseMapper;


    @Override
    public SDto findById(ID id) throws BaseException {

        E entity = baseRepository.findById(id).orElseThrow(BaseException::new);
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
        entity.createdDate = LocalDateTime.now();
        entity.lastModifiedDate = null;
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
        //Completion
        currentEntity.lastModifiedDate = LocalDateTime.now();
        //Saving
        E returnedEntity = baseRepository.save(currentEntity);
        //Convert Entity to Dto & Return
        return baseMapper.entityToRes(returnedEntity);
    }

    @Override
    public void deleteSafelyById(ID id) throws BaseException {

        E entity = baseRepository.findById(id).orElseThrow(BaseException::new);
        if (entity.getDeleted()) throw new BaseException("Requested Entity Was Already Deleted!");
        //Set safe delete
        entity.setDeleted(true);
        entity.setLastModifiedDate(LocalDateTime.now());
        //Saving
        baseRepository.save(entity);
    }
}
