package br.com.codecursos.ms_user.controller;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.domain.Teacher;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import br.com.codecursos.ms_user.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacherDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body((teacherService.deleteById(id)));
    }

    @PutMapping("/update-password")
    public ResponseEntity<Teacher> updatePassword(@RequestParam Long teacherId, @RequestParam String oldPassword, @RequestParam String newPassword){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.updatePassword(teacherId,oldPassword,newPassword));
    }
}
