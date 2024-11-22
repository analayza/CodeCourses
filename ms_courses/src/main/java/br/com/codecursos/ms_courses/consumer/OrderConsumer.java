package br.com.codecursos.ms_courses.consumer;

import br.com.codecursos.ms_courses.constant.RabbitConstants;
import br.com.codecursos.ms_courses.domain.Course;
import br.com.codecursos.ms_courses.domain.CourseUser;
import br.com.codecursos.ms_courses.dto.CourseUserDTO;
import br.com.codecursos.ms_courses.dto.response.CourseUserResponseDTO;
import br.com.codecursos.ms_courses.mapper.CourseMapper;
import br.com.codecursos.ms_courses.mapper.CourseUserMapper;
import br.com.codecursos.ms_courses.service.CourseUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final ObjectMapper objectMapper;
    private final CourseUserService courseUserService;
    private final CourseUserMapper courseUserMapper;

    @RabbitListener(queues = RabbitConstants.ORDER_QUEUE)
    public void orderConsumer(final Message message){
        try{

            var courseUserResponseDTO = objectMapper.readValue(message.getBody(), CourseUserResponseDTO.class);

            CourseUserDTO courseUserDTO = CourseUserDTO.builder()
                    .userId(courseUserResponseDTO.getUserId())
                    .userName(courseUserResponseDTO.getUserName())
                    .courseId(courseUserResponseDTO.getCourseId())
                    .build();

            courseUserService.save(courseUserDTO);

        }catch (Exception ex){
            throw new IllegalArgumentException("Erro ao converter menssagem no consumidor");
        }
    }

}
