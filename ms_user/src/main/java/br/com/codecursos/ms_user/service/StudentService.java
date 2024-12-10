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
    private Student student;

    public Student save(StudentDTO studentDTO){
        return studentRepository.save(studentMapper.dtoToEntity(studentDTO));
    }

    public Student deleteById(Long id) {
        student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + " not found"));
        studentRepository.deleteById(id);
        return student;
    }


    public Student updatePassword(Long studentId, String oldPassword, String newPassword) {
        student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("ID " + studentId + " not found"));
        if (!student.getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException("Old password does not match");
        }
        student.setPassword(newPassword);
        return studentRepository.save(student);
    }

    public StudentDTO findByEmailAndPassword(String email, String password){
        return studentMapper.entityToDto(studentRepository.findByEmailAndPassword(email, password));
    }
}
