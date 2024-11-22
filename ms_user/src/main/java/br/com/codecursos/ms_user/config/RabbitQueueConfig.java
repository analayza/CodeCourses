package br.com.codecursos.ms_user.config;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


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


