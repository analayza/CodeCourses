package br.com.codecursos.ms_user.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    private LocalDateTime dateTimeCreation;
    private LocalDateTime dateUpdate;

    @PrePersist
    public void getDateCreation(){
        dateTimeCreation = LocalDateTime.now();
    }

    @PreUpdate
    public void getDateUpdate(){
        dateUpdate = LocalDateTime.now();
    }
}
