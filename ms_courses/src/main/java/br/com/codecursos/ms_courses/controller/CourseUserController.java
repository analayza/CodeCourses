package br.com.codecursos.ms_courses.controller;

import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.CourseUserDTO;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import br.com.codecursos.ms_courses.mapper.CourseModuleMapper;
import br.com.codecursos.ms_courses.mapper.CourseUserMapper;
import br.com.codecursos.ms_courses.service.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseUser")
@RequiredArgsConstructor
public class CourseUserController {

    private final CourseUserService courseUserService;
    private final CourseUserMapper courseUserMapper;

    @GetMapping("/listCourseUsers/{id}")
    public ResponseEntity<List<CourseUserDTO>> findByModuleCourseId(@PathVariable("id") Long id) {
        List<CourseUser> courseUsers = courseUserService.findByCourseUser(id);
        List<CourseUserDTO> courseUserDTOS = courseUsers.stream()
                .map(courseUserMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(courseUserDTOS);
    }

}
