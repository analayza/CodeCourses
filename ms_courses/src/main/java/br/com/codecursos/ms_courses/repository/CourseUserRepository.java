package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseUserRepository extends JpaRepository<CourseUser, Long> {

    @Query("SELECT cu FROM CourseUser cu WHERE cu.courseId = :courseId")
    List<CourseUser> findStudentsByCourseId(@Param("courseId") Long courseId);

    @Query("""
       SELECT new br.com.codecursos.ms_courses.domain.Course(
           c.id, c.title, c.value, c.description, c.image, c.idTeacher)
       FROM Course c
       JOIN CourseUser cu ON cu.courseId = c.id
       WHERE cu.userId = :userId
       """)
    List<Course> findCoursesByUserId(@Param("userId") Long userId);

    @Query("""
    SELECT new br.com.codecursos.ms_courses.domain.Course(
        c.id, c.title, c.value, c.description, c.image, c.idTeacher)
    FROM Course c
    LEFT JOIN CourseUser cu ON cu.courseId = c.id AND cu.userId = :userId
    WHERE cu.courseId IS NULL
    """)
    List<Course> findCoursesThatStudentDoesNotHave(@Param("userId") Long userId);


}
