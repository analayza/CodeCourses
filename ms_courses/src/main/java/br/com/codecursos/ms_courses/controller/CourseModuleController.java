package br.com.codecursos.ms_courses.controller;


import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.CourseModule;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import br.com.codecursos.ms_courses.dto.CourseModuleDTO;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import br.com.codecursos.ms_courses.mapper.CourseModuleMapper;
import br.com.codecursos.ms_courses.service.CourseModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CourseModuleController {

    private final CourseModuleService courseModuleService;

    private final CourseModuleMapper courseModuleMapper;

    @PostMapping("/save")
    public ResponseEntity<CourseModule> save(@RequestBody CourseModuleDTO courseModuleDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseModuleService.save(courseModuleDTO));
    }

    @GetMapping("/listmodule")
    public ResponseEntity<List<CourseModule>> findByModule(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseModuleService.findByModule());
    }

    @GetMapping("/listModuleCourse/{id}")
    public ResponseEntity<List<CourseModuleDTO>> findByModuleCourseId(@PathVariable("id") Long id) {
        List<CourseModule> coursesModules = courseModuleService.findByModuleCourseId(id);
        List<CourseModuleDTO> courseModuleDTOS = coursesModules.stream()
                .map(courseModuleMapper::modelToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(courseModuleDTOS);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ModuleClass>deleteModule(@PathVariable("id") Long id){
        try {
            courseModuleService.deleteModule(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>updateModule(@PathVariable("id") Long id, @RequestBody CourseModuleDTO courseModuleDTO){
        try {
            courseModuleService.updateModule(id, courseModuleDTO);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
