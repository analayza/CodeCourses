package br.com.codecursos.ms_user.repository;

import br.com.codecursos.ms_user.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
