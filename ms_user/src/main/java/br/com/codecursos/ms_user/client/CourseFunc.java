package br.com.codecursos.ms_user.client;

import br.com.codecursos.ms_user.dto.request.ClassDTO;
import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.dto.request.ModuleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "courseFunc", url = "${feign.course.func-course.url}")
public interface CourseFunc {
    @PostMapping("/course/save")
    CourseDTO saveCourse(@RequestBody CourseDTO courseDTO);

    @DeleteMapping("/course/{id}")
    void deleteCourse(@PathVariable("id") Long id);

    @PutMapping("/course/{id}")
    void updateCourse(@PathVariable("id") Long id, CourseDTO courseDTO);

    @GetMapping("/course/listCourseTeacher/{id}")
    List<CourseDTO> listCourseTeacher(@PathVariable("id") Long id);

    @PostMapping("/module/save")
    ModuleDTO saveModule(@RequestBody ModuleDTO moduleDTO);

    @DeleteMapping("/module/{id}")
    void deleteModule(@PathVariable("id") Long id);

    @PutMapping("/module/{id}")
    void updateModule(@PathVariable("id") Long id, ModuleDTO moduleDTO);

    @GetMapping("/module/listModuleCourse/{id}")
    List<ModuleDTO> listModuleCourseId(@PathVariable("id") Long id);

    @PostMapping("/moduleclass/save")
    ClassDTO saveClass(@RequestBody ClassDTO classDTO);

    @DeleteMapping("moduleclass/{id}")
    void deleteClass(@PathVariable("id") Long id);

    @PutMapping("/moduleclass/{id}")
    void updateClass(@PathVariable("id") Long id, ClassDTO classDTO);

    @GetMapping("/moduleclass/listClassModule/{id}")
    List<ClassDTO> listClassModuleId(@PathVariable("id") Long id);


}
