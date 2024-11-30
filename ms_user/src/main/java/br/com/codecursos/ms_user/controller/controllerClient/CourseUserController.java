package br.com.codecursos.ms_user.controller.controllerClient;

import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.dto.request.CourseUserDTO;
import br.com.codecursos.ms_user.messenger.request.CourseUserRequestDTO;
import br.com.codecursos.ms_user.service.serviceclient.CourseService;
import br.com.codecursos.ms_user.service.serviceclient.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registerCourse")
@RequiredArgsConstructor
public class CourseUserController {

    private final CourseUserService courseUserService;

    @PostMapping("/Register")
    public ResponseEntity<Void> createRegister(@RequestBody CourseUserRequestDTO courseUserRequestDTO){
        courseUserService.sendMessage(courseUserRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listCourseUsers/{id}")
    public ResponseEntity<List<CourseUserDTO>> listCourseUsers(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseUserService.listCourseUsers(id));
    }

    @GetMapping("/findCoursesFromStudent/{id}")
    public ResponseEntity<List<CourseDTO>> listByCourseStudent(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseUserService.listByCourseStudent(id));
    }
    @GetMapping("/listFindCoursesThatStudentDoesNotHave/{id}")
    public ResponseEntity<List<CourseDTO>> listFindCoursesThatStudentDoesNotHave(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseUserService.findCoursesThatStudentDoesNotHave(id));
    }

}
