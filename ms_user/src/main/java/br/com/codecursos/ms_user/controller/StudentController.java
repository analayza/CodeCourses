package br.com.codecursos.ms_user.controller;


import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.dto.StudentDTO;
import br.com.codecursos.ms_user.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteById( @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteById(id));
    }

    @PutMapping("/update-password")
    public ResponseEntity<Student> updatePassword(@RequestParam Long studentId, @RequestParam String oldPassword, @RequestParam String newPassword){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePassword(studentId,oldPassword,newPassword));
    }
}