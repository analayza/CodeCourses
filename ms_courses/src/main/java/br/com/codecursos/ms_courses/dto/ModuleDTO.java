package br.com.codecursos.ms_courses.dto;

import br.com.codecursos.ms_courses.domain.Class;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ModuleDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String title;

    private List<Class> class_list;
}
