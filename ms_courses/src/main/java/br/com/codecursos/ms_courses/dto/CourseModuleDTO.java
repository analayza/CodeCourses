package br.com.codecursos.ms_courses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseModuleDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String title;

    private Long courseId;
}
