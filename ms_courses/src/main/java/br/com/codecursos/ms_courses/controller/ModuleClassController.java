package br.com.codecursos.ms_courses.controller;


import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import br.com.codecursos.ms_courses.service.ModuleClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moduleclass")
@RequiredArgsConstructor
public class ModuleClassController {

    private final ModuleClassService moduleClassService;

    @PostMapping("/save")
    public ResponseEntity<ModuleClass> save(@RequestBody ModuleClassDTO moduleClassDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(moduleClassService.save(moduleClassDTO));
    }

    @GetMapping("/listmoduleclass")
    public ResponseEntity<List<ModuleClass>>findByModuleClass(){
        return ResponseEntity.status(HttpStatus.OK).body(moduleClassService.findByModuleClass());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModuleClass>deleteModuleClass(@PathVariable("id") Long id){
        try {
            moduleClassService.deleteModuleClass(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>updateModuleClass(@PathVariable("id") Long id, @RequestBody ModuleClassDTO moduleClassDTO){
        try {
            moduleClassService.updateModuleClass(id, moduleClassDTO);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
