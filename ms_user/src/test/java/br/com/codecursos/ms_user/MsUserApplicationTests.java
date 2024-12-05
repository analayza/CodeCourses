package br.com.codecursos.ms_user;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MsUserApplicationTests {

	@MockBean
	private RabbitAdmin rabbitAdmin;
	@Test
	void contextLoads() {
	}

}
