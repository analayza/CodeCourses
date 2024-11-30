package br.com.codecursos.ms_user.service.serviceclient;

import br.com.codecursos.ms_user.client.CourseFunc;
import br.com.codecursos.ms_user.dto.request.ClassDTO;
import br.com.codecursos.ms_user.dto.request.CourseDTO;
import br.com.codecursos.ms_user.dto.request.CourseUserDTO;
import br.com.codecursos.ms_user.messenger.producer.OrderQueueProducer;
import br.com.codecursos.ms_user.messenger.request.CourseUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseUserService {

    private final OrderQueueProducer orderQueueProducer;
    private final CourseFunc courseFunc;

    public void sendMessage(final CourseUserRequestDTO courseUserRequestDTO){
        orderQueueProducer.sendMessage(courseUserRequestDTO);
    }

    public List<CourseUserDTO> listCourseUsers(Long id){
        return courseFunc.listCourseUsers(id);
    }

    public List<CourseDTO> listByCourseStudent(Long id){
        return courseFunc.listByCourseStudent(id);
    }

    public List<CourseDTO> findCoursesThatStudentDoesNotHave(Long id){
        return courseFunc.findCoursesThatStudentDoesNotHave(id);
    }

}
