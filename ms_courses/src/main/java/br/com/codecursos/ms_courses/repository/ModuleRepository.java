package br.com.codecursos.ms_courses.repository;

import br.com.codecursos.ms_courses.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query(value = "INSERT INTO module_class_list (module_id, class_id) VALUES (:moduleId, :classId)", nativeQuery = true)
    void saveModuleClass(@Param("moduleId") Long moduleId, @Param("classId") Long classId);
}
