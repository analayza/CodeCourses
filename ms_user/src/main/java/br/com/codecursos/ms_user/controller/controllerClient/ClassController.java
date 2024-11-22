package br.com.codecursos.ms_user.controller.controllerClient;

import br.com.codecursos.ms_user.dto.request.ClassDTO;
import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.service.serviceclient.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping("/save")
    public ResponseEntity<ClassDTO> saveCourse(@RequestBody ClassDTO classDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(classService.saveClass(classDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse (@PathVariable("id") Long id){
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long id, @RequestBody ClassDTO classDTO){
        classService.updateClass(id, classDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listClassModule/{id}")
    public ResponseEntity<List<ClassDTO>> listCourseByTeacher(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(classService.listClassModuleId(id));
    }

}
