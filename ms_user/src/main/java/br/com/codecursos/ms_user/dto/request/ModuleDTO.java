package br.com.codecursos.ms_user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuleDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String title;

    private Long courseId;

}
