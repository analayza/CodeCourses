package br.com.codecursos.ms_courses.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
public class CourseDTO {

    private Long id;

    @NotBlank(message = "O titulo não pode ser vazio.")
    private String title;

    @NotNull(message = "O valor não pode ser nulo.")
    private BigDecimal value;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;

    @NotNull
    private Long idTeacher;
}
