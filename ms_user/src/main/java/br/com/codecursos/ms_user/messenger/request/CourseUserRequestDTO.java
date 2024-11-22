package br.com.codecursos.ms_user.messenger.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseUserRequestDTO {

    private Long id;

    private Long courseId;

    private Long userId;

    private String userName;

}
