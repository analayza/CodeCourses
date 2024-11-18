package br.com.codecursos.ms_user.controller;


import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.dto.StudentDTO;
import br.com.codecursos.ms_user.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDTO));
    }

    @PostMapping("/delete")
    public ResponseEntity<Student> deleteById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteById(id));
    }

    @PostMapping("/update-password")
    public ResponseEntity<Student> updatePassword(Long studentId, String oldPassword, String newPassword){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePassword(studentId,oldPassword,newPassword));
    }
}