package br.com.codecursos.ms_user.controller;

import br.com.codecursos.ms_user.dto.StudentDTO;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import br.com.codecursos.ms_user.service.StudentService;
import br.com.codecursos.ms_user.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping("/")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password) {
        StudentDTO student = studentService.findByEmailAndPassword(email, password);
        if (student != null) {
            return ResponseEntity.ok(student);
        }

        TeacherDTO teacher = teacherService.findByEmailAndPassword(email, password);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou Senha inválidos.");
    }

}
