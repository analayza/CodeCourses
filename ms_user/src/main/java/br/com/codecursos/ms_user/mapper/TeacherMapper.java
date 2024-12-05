package br.com.codecursos.ms_user.mapper;

import br.com.codecursos.ms_user.domain.Teacher;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
<<<<<<< HEAD

    //@Mapping(target = "id", ignore = true)
=======
    @Mapping(target = "id", ignore = true)
>>>>>>> bae72465dd3ac7792d0f706c2cdfead8b3034daf
    Teacher tdoToEntity(TeacherDTO teacherDTO);

}
