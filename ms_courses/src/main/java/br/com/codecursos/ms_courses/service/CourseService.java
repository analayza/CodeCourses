package br.com.codecursos.ms_courses.service;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import br.com.codecursos.ms_courses.mapper.CourseMapper;
import br.com.codecursos.ms_courses.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course save(CourseDTO courseDTO){
        return courseRepository.save(courseMapper.tdoToEntity(courseDTO));
    }

    public List<Course> findByCourse(){
        return courseRepository.findAll();
    }

    public List<Course> findByCourseTeacher(Long id){
        return courseRepository.findCoursesByTeacher(id);
    }

    public void deleteCourse(Long id){
        if (!courseRepository.existsById(id)) {
            throw new IllegalArgumentException("Curso com o ID " + id + " não encontrado.");
        }
        courseRepository.deleteById(id);
    }
    @Transactional
    public void updateCourse(Long id, CourseDTO courseDTO) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalArgumentException("Curso com ID " + id + " não encontrado.");
        }
        courseRepository.updateCourse(
                id,
                courseDTO.getTitle(),
                courseDTO.getValue(),
                courseDTO.getDescription(),
                courseDTO.getIdTeacher()
        );
    }
}
