package br.com.codecursos.ms_user.repository;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.email = :email AND t.password = :password")
    Teacher findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
