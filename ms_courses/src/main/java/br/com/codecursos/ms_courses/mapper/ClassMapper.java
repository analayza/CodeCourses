package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.Class;
import br.com.codecursos.ms_courses.dto.ClassDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    @Mapping(target = "id", ignore = true)
    Class dtoToModel(ClassDTO classDTO);
}
