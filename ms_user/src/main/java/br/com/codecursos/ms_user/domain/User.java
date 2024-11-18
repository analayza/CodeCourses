package br.com.codecursos.ms_user.domain;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@MappedSuperclass
public abstract class User extends BaseEntity {

    private String name;
    private String email;
    private String password;

}
