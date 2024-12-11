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


    private String title;


    private BigDecimal value;


    private String description;


    private String image;


    private Long idTeacher;
}
