package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    @Query("UPDATE Course c SET " +
            "c.title = COALESCE(:title, c.title), " +
            "c.value = COALESCE(:value, c.value), " +
            "c.description = COALESCE(:description, c.description) " +
            "WHERE c.id = :id " +
            "AND c.idTeacher = :idTeacher")
    void updateCourse(@Param("id") Long id,
                      @Param("title") String title,
                      @Param("value") BigDecimal value,
                      @Param("description") String description,
                      @Param("idTeacher") Long idTeacher);


    @Query("SELECT c FROM Course c WHERE c.idTeacher = :idTeacher")
    List<Course> findCoursesByTeacher(@Param("idTeacher") Long idTeacher);


}

