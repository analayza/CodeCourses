package br.com.codecursos.ms_user.service.serviceclient;

import br.com.codecursos.ms_user.messenger.producer.OrderQueueProducer;
import br.com.codecursos.ms_user.messenger.request.CourseUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseUserService {

    private final OrderQueueProducer orderQueueProducer;

    public void sendMessage(final CourseUserRequestDTO courseUserRequestDTO){
        orderQueueProducer.sendMessage(courseUserRequestDTO);
    }

}
