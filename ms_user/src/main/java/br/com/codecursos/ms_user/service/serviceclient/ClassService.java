package br.com.codecursos.ms_user.service.serviceclient;

import br.com.codecursos.ms_user.client.CourseFunc;
import br.com.codecursos.ms_user.dto.request.ClassDTO;
import br.com.codecursos.ms_user.dto.request.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final CourseFunc courseFunc;

    public ClassDTO saveClass(ClassDTO classDTO){
        return courseFunc.saveClass(classDTO);
    }

    public void deleteClass(Long id){
        courseFunc.deleteClass(id);
    }

    public void updateClass(Long id, ClassDTO classDTO){
        courseFunc.updateClass(id, classDTO);
    }

    public List<ClassDTO> listClassModuleId(Long id){
        return courseFunc.listClassModuleId(id);
    }
}
