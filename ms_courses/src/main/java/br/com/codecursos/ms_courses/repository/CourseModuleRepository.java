package br.com.codecursos.ms_courses.repository;
import br.com.codecursos.ms_courses.domain.CourseModule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {

    @Modifying
    @Query("UPDATE CourseModule c SET " +
            "c.title = COALESCE(:title, c.title), " +
            "c.courseId = COALESCE(:courseId, c.courseId) " +
            "WHERE c.id = :id")
    void updateCourseModule(@Param("id") Long id,
                            @Param("title") String title,
                            @Param("courseId") Long courseId);
}
