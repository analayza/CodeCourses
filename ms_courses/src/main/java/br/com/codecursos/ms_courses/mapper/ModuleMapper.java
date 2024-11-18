package br.com.codecursos.ms_courses.mapper;

import br.com.codecursos.ms_courses.domain.Module;
import br.com.codecursos.ms_courses.dto.ModuleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "class_list", ignore = true)
    Module dtoToModel(ModuleDTO moduleDTO);
}
