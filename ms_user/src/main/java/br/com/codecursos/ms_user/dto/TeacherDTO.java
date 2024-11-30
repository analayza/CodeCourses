package br.com.codecursos.ms_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;
    @Email(message = "O email é inválido")
    private String email;
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String password;
    private String profile;
}
