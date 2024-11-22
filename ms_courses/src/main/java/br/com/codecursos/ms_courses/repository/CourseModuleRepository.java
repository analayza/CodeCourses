package br.com.codecursos.ms_courses.repository;
import br.com.codecursos.ms_courses.domain.CourseModule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {

    @Modifying
    @Query("UPDATE CourseModule c SET c.title = :title WHERE c.id = :id")
    void updateCourseModuleTitle(@Param("id") Long id, @Param("title") String title);

    @Query("SELECT m FROM CourseModule m WHERE m.courseId = :courseId")
    List<CourseModule> findModulesByCourseId(@Param("courseId") Long courseId);

}
