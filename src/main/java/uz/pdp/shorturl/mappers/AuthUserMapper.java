package uz.pdp.shorturl.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.shorturl.dtos.auth.AuthUserCreateDto;
import uz.pdp.shorturl.entities.AuthUser;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthUserMapper {
    AuthUser toEntity(AuthUserCreateDto authUserCreateDto);

    /*@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthUser partialUpdate(AuthUserCreateDto authUserCreateDto, @MappingTarget AuthUser authUser);*/
}