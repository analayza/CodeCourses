package br.com.codecursos.ms_user.service.serviceclient;

import br.com.codecursos.ms_user.client.CourseFunc;
import br.com.codecursos.ms_user.dto.request.ModuleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final CourseFunc courseFunc;

    public ModuleDTO saveModule(ModuleDTO moduleDTO){
        return courseFunc.saveModule(moduleDTO);
    }

    public void deleteModule(Long id){
        courseFunc.deleteModule(id);
    }

    public void updateModule(Long id, ModuleDTO moduleDTO){
        courseFunc.updateModule(id, moduleDTO);
    }

    public List<ModuleDTO> moduleCourseById(Long id){
        return courseFunc.listModuleCourseId(id);
    }
}
