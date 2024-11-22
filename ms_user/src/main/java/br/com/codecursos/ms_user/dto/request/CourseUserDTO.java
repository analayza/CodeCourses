package br.com.codecursos.ms_user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseUserDTO {

    private Long id;

    @NotNull
    private Long courseId;

    private Long userId;

    private String userName;
}
