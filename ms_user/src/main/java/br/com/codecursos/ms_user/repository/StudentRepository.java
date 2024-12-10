package br.com.codecursos.ms_user.repository;

import br.com.codecursos.ms_user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
    Student findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
