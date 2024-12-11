package br.com.codecursos.ms_user.controller.controllerClient;

import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.dto.request.ModuleDTO;
import br.com.codecursos.ms_user.service.serviceclient.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleController {

    private final ModuleService moduleService;

    @PostMapping("/save")
    public ResponseEntity<ModuleDTO> saveModule(@RequestBody ModuleDTO moduleDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(moduleService.saveModule(moduleDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule (@PathVariable("id") Long id){
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateModule(@PathVariable("id") Long id, @RequestBody ModuleDTO moduleDTO){
        moduleService.updateModule(id, moduleDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listModuleCurseById/{id}")
    public ResponseEntity<List<ModuleDTO>> listModuleCourseById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(moduleService.moduleCourseById(id));
    }
}
