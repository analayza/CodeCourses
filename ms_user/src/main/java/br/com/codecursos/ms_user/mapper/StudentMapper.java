package br.com.codecursos.ms_user.mapper;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "coursesParticipating", ignore = true)
    Student dtoToEntity(StudentMapper studentMapper);

}
