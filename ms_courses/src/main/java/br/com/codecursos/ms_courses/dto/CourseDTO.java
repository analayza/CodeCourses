package br.com.codecursos.ms_courses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class CourseDTO {
    private Long id;

    @NotBlank(message = "O titulo não pode ser vazio.")
    private String title;

    @NotBlank(message = "O valor não pode ser vazio.")
    private BigDecimal value;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;
}
