package ir.mapsa.librarymanagement.mapper;

import ir.mapsa.librarymanagement.base.IBaseMapper;
import ir.mapsa.librarymanagement.dto.MemberQDto;
import ir.mapsa.librarymanagement.dto.MemberSDto;
import ir.mapsa.librarymanagement.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMemberMapper extends IBaseMapper<Member, MemberQDto, MemberSDto> {

}
