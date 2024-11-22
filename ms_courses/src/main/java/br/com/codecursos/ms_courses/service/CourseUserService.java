package br.com.codecursos.ms_courses.service;

import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.dto.CourseUserDTO;
import br.com.codecursos.ms_courses.mapper.CourseUserMapper;
import br.com.codecursos.ms_courses.repository.CourseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseUserService {

    private final CourseUserRepository courseUserRepository;
    private final CourseUserMapper courseUserMapper;

    public CourseUser save(CourseUserDTO courseUserDTO){
        return courseUserRepository.save(courseUserMapper.dtoToEntity(courseUserDTO));
    }

    public List<CourseUser> findByCourseUser(Long id){
        return courseUserRepository.findStudentsByCourseId(id);
    }

}
