package br.com.codecursos.ms_courses.controller;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import br.com.codecursos.ms_courses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.save(courseDTO));
    }

    @GetMapping("/listcourse")
    public ResponseEntity<List<Course>>findByCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findByCourse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course>deleteCourse(@PathVariable("id") Long id){
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO) {
        try {
            courseService.updateCourse(id, courseDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
