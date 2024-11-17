package br.com.codecursos.ms_user.repository;

import br.com.codecursos.ms_user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
