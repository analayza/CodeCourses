package br.com.codecursos.ms_courses.dto;

import br.com.codecursos.ms_courses.domain.Module;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseDTO {
    private Long id;

    @NotBlank(message = "O titulo não pode ser vazio.")
    private String title;

    @NotBlank(message = "O valor não pode ser vazio.")
    private BigDecimal value;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;

    private List<Module> module;
}
