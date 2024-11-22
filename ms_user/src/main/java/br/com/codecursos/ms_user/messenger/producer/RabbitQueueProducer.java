package br.com.codecursos.ms_user.messenger.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public class RabbitQueueProducer {

    private final RabbitTemplate rabbitTemplate;
    public void sendMessage(final  String queue, final Object object){
        rabbitTemplate.convertAndSend(queue, object);
    }

}
