package br.com.codecursos.ms_user.controller.controllerClient;

import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.service.serviceclient.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.saveCourse(courseDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse (@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id, courseDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listCourseByTeacher/{id}")
    public ResponseEntity<List<CourseDTO>> listCourseByTeacher(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listCourseByTeacher(id));
    }
}
