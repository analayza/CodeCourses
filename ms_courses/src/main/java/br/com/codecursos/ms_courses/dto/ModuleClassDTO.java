package br.com.codecursos.ms_courses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuleClassDTO {

    private Long id;

    @NotBlank(message = "O título não pode ser vazio.")
    private String title;

    @NotBlank(message = "A url da aula não pode ser vazia.")
    private String url;

    private Long moduleId;
}
