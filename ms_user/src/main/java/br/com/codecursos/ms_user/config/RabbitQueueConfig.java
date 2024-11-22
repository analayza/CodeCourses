package br.com.codecursos.ms_user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

@RequiredArgsConstructor
public class RabbitQueueConfig {

    private final RabbitAdmin rabbitAdmin;
    private final String queue;
    private final String exchange;

    //Cria a fila
    public void createQueue(){
        rabbitAdmin.declareQueue(QueueBuilder.durable(queue).build());
    }

    public void createExchange(){
        rabbitAdmin.declareExchange(ExchangeBuilder.directExchange(exchange).build());
    }

    //Vincular a fila ao exchange
    public void createQueueBinding(){
        rabbitAdmin.declareBinding
                (new Binding(queue, Binding.DestinationType.QUEUE, exchange, queue, null));
    }
}


