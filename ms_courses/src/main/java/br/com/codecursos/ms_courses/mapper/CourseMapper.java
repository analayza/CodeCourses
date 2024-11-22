package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    Course dtoToEntity(CourseDTO courseDTO);

    CourseDTO entityToDto(Course course);
}

