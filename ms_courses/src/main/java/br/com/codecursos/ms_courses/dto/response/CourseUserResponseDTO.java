package br.com.codecursos.ms_courses.dto.response;

import br.com.codecursos.ms_courses.domain.Course;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseUserResponseDTO {

    private Long id;

    @NotNull
    private Long courseId;

    private Long userId;

    private String userName;


}
