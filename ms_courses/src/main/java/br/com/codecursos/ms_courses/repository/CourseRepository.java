package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "INSERT INTO course_module (course_id, module_id) VALUES (:courseId, :moduleId)", nativeQuery = true)
    void saveCourseModule(@Param("courseId") Long courseId, @Param("moduleId") Long moduleId);
}
