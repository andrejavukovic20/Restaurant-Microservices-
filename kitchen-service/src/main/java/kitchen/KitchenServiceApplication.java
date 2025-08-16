package kitchen;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class KitchenServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KitchenServiceApplication.class, args);
	}
}
