package br.com.codecursos.ms_user.domain;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@MappedSuperclass
public abstract class User extends BaseEntity {

    private String name;
    private String email;
    private String password;

}
