package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.CourseModule;
import br.com.codecursos.ms_courses.dto.CourseModuleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseModuleMapper {
    @Mapping(target = "id", ignore = true)
    CourseModule dtoToModel(CourseModuleDTO courseModuleDTO);
}

