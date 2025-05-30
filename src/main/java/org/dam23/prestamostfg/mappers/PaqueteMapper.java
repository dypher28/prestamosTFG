package org.dam23.prestamostfg.mappers;

import org.dam23.prestamostfg.dtos.PaqueteDto;
import org.dam23.prestamostfg.entities.Paquete;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface PaqueteMapper {
    Paquete toEntity(PaqueteDto paqueteDto);

    PaqueteDto toDto(Paquete paquete);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Paquete partialUpdate(PaqueteDto paqueteDto, @MappingTarget Paquete paquete);
}