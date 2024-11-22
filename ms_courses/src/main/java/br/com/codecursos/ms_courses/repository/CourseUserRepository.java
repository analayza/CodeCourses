package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.CourseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseUserRepository extends JpaRepository<CourseUser, Long> {

    @Query("SELECT cu FROM CourseUser cu WHERE cu.courseId = :courseId")
    List<CourseUser> findStudentsByCourseId(@Param("courseId") Long courseId);
}
