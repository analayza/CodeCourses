package br.com.codecursos.ms_user.mapper;

import br.com.codecursos.ms_user.domain.Teacher;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    //@Mapping(target = "id", ignore = true)
    //@Mapping(target = "coursesCreated", ignore = true)
    @Mapping(target = "id", ignore = true)
    Teacher tdoToEntity(TeacherDTO teacherDTO);

}
