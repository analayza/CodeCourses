package br.com.codecursos.ms_user.client;

import br.com.codecursos.ms_user.dto.request.CourseDTO;
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
}
