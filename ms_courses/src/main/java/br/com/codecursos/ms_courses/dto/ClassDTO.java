package br.com.codecursos.ms_courses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClassDTO {
    private Long id;

    @NotBlank(message = "O título não pode ser vazio.")
    private String title;

    @NotBlank(message = "A imagem não pode ser vazia.")
    private String image;

    @NotBlank(message = "A url da aula não pode ser vazia.")
    private String url;
}
