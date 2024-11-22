package br.com.codecursos.ms_user.messenger.producer;

import br.com.codecursos.ms_user.constants.RabbitConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderQueueProducer extends RabbitQueueProducer {
    public OrderQueueProducer(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

//    public void sendMessage(final OrderRequestDTO orderRequestDTO) {
//        super.sendMessage(RabbitConstants.ORDER_QUEUE, orderRequestDTO);
//    }
}
