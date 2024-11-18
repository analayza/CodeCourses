package br.com.codecursos.ms_user.controller;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.domain.Teacher;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import br.com.codecursos.ms_user.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacherDTO));
    }

    @PostMapping("/delete")
    public ResponseEntity<Teacher> deleteById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body((teacherService.deleteById(id)));
    }

    @PostMapping("/update-password")
    public ResponseEntity<Teacher> updatePassword(Long teacherId, String oldPassword, String newPassword){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.updatePassword(teacherId,oldPassword,newPassword));
    }
}
