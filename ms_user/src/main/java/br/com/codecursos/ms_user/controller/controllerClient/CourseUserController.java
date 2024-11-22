package br.com.codecursos.ms_user.controller.controllerClient;

import br.com.codecursos.ms_user.messenger.request.CourseUserRequestDTO;
import br.com.codecursos.ms_user.service.serviceclient.CourseService;
import br.com.codecursos.ms_user.service.serviceclient.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
