package br.com.codecursos.ms_courses.service;

import br.com.codecursos.ms_courses.domain.CourseModule;
import br.com.codecursos.ms_courses.dto.CourseModuleDTO;
import br.com.codecursos.ms_courses.mapper.CourseModuleMapper;
import br.com.codecursos.ms_courses.repository.CourseModuleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseModuleService {

    private final CourseModuleRepository courseModuleRepository;
    private final CourseModuleMapper courseModuleMapper;
    public CourseModule save(CourseModuleDTO moduleDTO){
        return courseModuleRepository.save(courseModuleMapper.dtoToModel(moduleDTO));
    }
    public List<CourseModule> findByModule(){
        return courseModuleRepository.findAll();
    }

    public void deleteModule(Long id){
        if (!courseModuleRepository.existsById(id)) {
            throw new IllegalArgumentException("O modulo com o ID " + id + " não foi encontrado.");
        }
        courseModuleRepository.deleteById(id);
    }

    @Transactional
    public void updateModule(Long id,  CourseModuleDTO courseModuleDTO) {
        if (!courseModuleRepository.existsById(id)) {
            throw new IllegalArgumentException("O modulo com o ID " + id + " não foi encontrado.");
        }
        courseModuleRepository.updateCourseModule(
                id,
                courseModuleDTO.getTitle(),
                courseModuleDTO.getCourseId()
        );
    }
}
