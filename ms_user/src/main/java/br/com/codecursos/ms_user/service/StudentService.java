package br.com.codecursos.ms_user.service;


import br.com.codecursos.ms_user.domain.Student;
import br.com.codecursos.ms_user.dto.StudentDTO;
import br.com.codecursos.ms_user.mapper.StudentMapper;
import br.com.codecursos.ms_user.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student save(StudentDTO studentDTO){
        return studentRepository.save(studentMapper.dtoToEntity(studentDTO));
    }

    public Student deleteById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + " not found"));
        studentRepository.deleteById(id);
        return student;
    }

}