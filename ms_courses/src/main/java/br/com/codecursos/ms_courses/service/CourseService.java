package br.com.codecursos.ms_courses.service;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.dto.CourseDTO;
import br.com.codecursos.ms_courses.mapper.CourseMapper;
import br.com.codecursos.ms_courses.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course save(CourseDTO courseDTO){
        return courseRepository.save(courseMapper.dtoToEntity(courseDTO));
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
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso com ID " + id + " não encontrado."));

        // Atualiza o título apenas se não for nulo ou vazio
        if (courseDTO.getTitle() != null && !courseDTO.getTitle().trim().isEmpty()) {
            existingCourse.setTitle(courseDTO.getTitle());
        }

        // Verifica se o valor é válido, maior que zero e não nulo
        if (courseDTO.getValue() != null && courseDTO.getValue().compareTo(BigDecimal.ZERO) > 0) {
            existingCourse.setValue(courseDTO.getValue());
        }

        // Atualiza a descrição apenas se não for nula ou vazia
        if (courseDTO.getDescription() != null && !courseDTO.getDescription().trim().isEmpty()) {
            existingCourse.setDescription(courseDTO.getDescription());
        }

        // Atualiza a imagem apenas se não for nula ou vazia
        if (courseDTO.getImage() != null && !courseDTO.getImage().trim().isEmpty()) {
            existingCourse.setImage(courseDTO.getImage());
        }

        // Salva as mudanças no banco
        courseRepository.save(existingCourse);
    }



}
