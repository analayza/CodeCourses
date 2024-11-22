package br.com.codecursos.ms_user.service.serviceclient;

import br.com.codecursos.ms_user.client.CourseFunc;
import br.com.codecursos.ms_user.dto.request.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseFunc courseFunc;

    public CourseDTO saveCourse(CourseDTO courseDTO){
        return courseFunc.saveCourse(courseDTO);
    }

    public void deleteCourse(Long id){
        courseFunc.deleteCourse(id);
    }

    public void updateCourse(Long id, CourseDTO courseDTO){
        courseFunc.updateCourse(id, courseDTO);
    }

    public List<CourseDTO> listCourseByTeacher(Long id){
        return courseFunc.listCourseTeacher(id);
    }
}
