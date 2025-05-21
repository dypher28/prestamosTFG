package org.dam23.prestamostfg.mappers;

import org.dam23.prestamostfg.dtos.LibroDto;
import org.dam23.prestamostfg.entities.Libro;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface LibroMapper {
    Libro toEntity(LibroDto libroDto);

    LibroDto toDto(Libro libro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Libro partialUpdate(LibroDto libroDto, @MappingTarget Libro libro);
}