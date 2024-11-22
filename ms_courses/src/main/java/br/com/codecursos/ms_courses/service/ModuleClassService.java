package br.com.codecursos.ms_courses.service;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.ModuleClass;
import br.com.codecursos.ms_courses.dto.ModuleClassDTO;
import br.com.codecursos.ms_courses.mapper.ModuleClassMapper;
import br.com.codecursos.ms_courses.repository.ModuleClassRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleClassService {

    private final ModuleClassRepository moduleClassRepository;
    private final ModuleClassMapper moduleClassMapper;

    public ModuleClass save(ModuleClassDTO moduleClassDTO){
       return moduleClassRepository.save(moduleClassMapper.dtoToClassModule(moduleClassDTO));
    }

    public List<ModuleClass> findByModuleClass(){
        return moduleClassRepository.findAll();
    }

    public List<ModuleClass> findClassesByModuleId(Long id){
        return moduleClassRepository.findClassesByModuleId(id);
    }

    public void deleteModuleClass(Long id){
        if (!moduleClassRepository.existsById(id)) {
            throw new IllegalArgumentException("A aula com o ID " + id + " não foi encontrada.");
        }
        moduleClassRepository.deleteById(id);
    }

    @Transactional
    public void updateModuleClass(Long id,  ModuleClassDTO moduleClassDTO) {
        if (!moduleClassRepository.existsById(id)) {
            throw new IllegalArgumentException("A aula com o ID " + id + " não foi encontrada.");
        }
        moduleClassRepository.updateModuleClass(
                id,
                moduleClassDTO.getTitle(),
                moduleClassDTO.getImage(),
                moduleClassDTO.getUrl(),
                moduleClassDTO.getModuleId()
        );
    }
}
