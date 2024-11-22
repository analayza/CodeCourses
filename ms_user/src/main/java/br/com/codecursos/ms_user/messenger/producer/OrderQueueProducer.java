package br.com.codecursos.ms_user.messenger.producer;

import br.com.codecursos.ms_user.constants.RabbitConstants;
import br.com.codecursos.ms_user.messenger.request.CourseUserRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderQueueProducer extends RabbitQueueProducer {

    public OrderQueueProducer(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    public void sendMessage(final CourseUserRequestDTO courseUserRequestDTO) {
        super.sendMessage(RabbitConstants.ORDER_QUEUE, courseUserRequestDTO);
    }
}
