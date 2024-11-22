package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.CourseModule;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.CourseModuleDTO;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModuleClassMapper {
    @Mapping(target = "id", ignore = true)
    ModuleClass dtoToClassModule(ModuleClassDTO moduleClassDTO);

    ModuleClassDTO modelToDto(ModuleClass moduleClass);
}
