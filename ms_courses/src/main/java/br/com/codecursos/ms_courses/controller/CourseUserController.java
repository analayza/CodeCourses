package br.com.codecursos.ms_courses.controller;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import br.com.codecursos.ms_courses.dto.CourseUserDTO;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import br.com.codecursos.ms_courses.mapper.CourseMapper;
import br.com.codecursos.ms_courses.mapper.CourseModuleMapper;
import br.com.codecursos.ms_courses.mapper.CourseUserMapper;
import br.com.codecursos.ms_courses.service.CourseService;
import br.com.codecursos.ms_courses.service.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseUser")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CourseUserController {

    private final CourseUserService courseUserService;
    private final CourseUserMapper courseUserMapper;
    private final CourseMapper courseMapper;

    @GetMapping("/listCourseUsers/{id}")
    public ResponseEntity<List<CourseUserDTO>> findByModuleCourseId(@PathVariable("id") Long id) {
        List<CourseUser> courseUsers = courseUserService.findByCourseUser(id);
        List<CourseUserDTO> courseUserDTOS = courseUsers.stream()
                .map(courseUserMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(courseUserDTOS);
    }

    @GetMapping("/findCoursesFromStudent/{id}")
    public ResponseEntity<List<CourseDTO>> findCoursesByUserId(@PathVariable("id") Long userId) {
        List<Course> courses = courseUserService.findByCoursesStudent(userId);
        List<CourseDTO> courseDTOs = courses.stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(courseDTOs);
    }

    @GetMapping("/findCoursesThatStudentDoesNotHave/{id}")
    public ResponseEntity<List<CourseDTO>> findCoursesNotByUserId(@PathVariable("id") Long userId) {
        List<Course> courses = courseUserService.findByCoursesNotStudent(userId);
        List<CourseDTO> courseDTOs = courses.stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(courseDTOs);
    }

}
