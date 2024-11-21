package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Modifying
    @Query("UPDATE Course c SET " +
            "c.title = COALESCE(:title, c.title), " +
            "c.value = COALESCE(:value, c.value), " +
            "c.description = COALESCE(:description, c.description) " +
            "WHERE c.id = :id")
    void updateCourse(@Param("id") Long id,
                      @Param("title") String title,
                      @Param("value") BigDecimal value,
                      @Param("description") String description);
}

