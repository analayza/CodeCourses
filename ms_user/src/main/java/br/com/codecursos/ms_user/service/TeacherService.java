package br.com.codecursos.ms_user.service;

import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.domain.Teacher;
import br.com.codecursos.ms_user.dto.StudentDTO;
import br.com.codecursos.ms_user.dto.TeacherDTO;
import br.com.codecursos.ms_user.mapper.TeacherMapper;
import br.com.codecursos.ms_user.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public Teacher save(TeacherDTO teacherDTO){
        return teacherRepository.save(teacherMapper.tdoToEntity(teacherDTO));
    }

    public Teacher deleteById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + " not found"));
        teacherRepository.deleteById(id);
        return teacher;
    }
}
