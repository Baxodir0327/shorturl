package uz.pdp.shorturl.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.shorturl.entities.Url;
import uz.pdp.shorturl.services.UrlCreateDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UrlMapper {
    Url toEntity(UrlCreateDTO urlCreateDTO);
}