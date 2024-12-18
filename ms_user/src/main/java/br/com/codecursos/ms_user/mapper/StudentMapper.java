package br.com.codecursos.ms_user.mapper;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

   @Mapping(target = "id", ignore = true)
   Student dtoToEntity(StudentDTO studentDTO);

    StudentDTO entityToDto(Student student);

}
