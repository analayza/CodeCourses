package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleClassRepository extends JpaRepository<ModuleClass, Long> {
    @Modifying
    @Query("UPDATE ModuleClass c SET " +
            "c.title = COALESCE(:title, c.title), " +
            "c.url = COALESCE(:url, c.url), " +
            "c.moduleId = COALESCE(:moduleId, c.moduleId) " +
            "WHERE c.id = :id")
    void updateModuleClass(@Param("id") Long id,
                           @Param("title") String title,
                           @Param("url") String url,
                           @Param("moduleId") Long moduleId);

    @Query("SELECT c FROM ModuleClass c WHERE c.moduleId = :moduleId")
    List<ModuleClass> findClassesByModuleId(@Param("moduleId") Long moduleId);
}
