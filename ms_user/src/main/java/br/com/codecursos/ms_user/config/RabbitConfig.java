package br.com.codecursos.ms_user.config;

import br.com.codecursos.ms_user.constants.RabbitConstants;
import lombok.Setter;
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

@Configuration //Para que ela rode com prioridade
@Setter
@ConfigurationProperties(prefix = "spring.rabbit" ) //Pega as configurações do aplication.yml
public class RabbitConfig {

    private String host;
    private int port;
    private String username;
    private String password;
    @Bean
    @Primary //Diz quem será o primeiro a ser chamado
    public RabbitAdmin rabbitAdmin(){ //Envia as mensagens
        return new RabbitAdmin(connectionFactory());
    }
    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(final Jackson2JsonMessageConverter converter){ //Faz a tradução das mensagens
        var rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }


    @Bean //Para dizer que o spring esta gerenciando
    public ConnectionFactory connectionFactory(){
        var connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(port);

        return connectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJacksonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean(RabbitConstants.ORDER_LISTENER_CONTAINER_FACTORY) //Conecta a fila
    public SimpleRabbitListenerContainerFactory orderQueueListenerFactory(){
        var simpleListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleListenerContainerFactory.setConnectionFactory(connectionFactory());
        return simpleListenerContainerFactory;
    }
}
