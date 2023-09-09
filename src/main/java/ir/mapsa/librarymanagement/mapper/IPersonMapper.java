package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.PersonQDto;
import ir.mapsa.librarymanagement.dto.PersonSDto;
import ir.mapsa.librarymanagement.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPersonMapper extends IBaseMapper<Person, PersonQDto, PersonSDto> {
}
