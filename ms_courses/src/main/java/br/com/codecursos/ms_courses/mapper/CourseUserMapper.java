package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.dto.CourseUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseUserMapper {

    @Mapping(target = "id", ignore = true)
    CourseUser dtoToEntity(CourseUserDTO courseUserDTO);

    CourseUserDTO entityToDto(CourseUser courseUser);

}
