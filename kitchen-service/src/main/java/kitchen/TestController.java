package kitchen;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	private final RabbitTemplate rabbitTemplate;
	
	public TestController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@PostMapping("/send/{orderId}")
	public ResponseEntity<String> sendOrderCreated(@PathVariable String orderId){
		rabbitTemplate.convertAndSend("order_created_queue", orderId);
		return ResponseEntity.ok("Message sent for order id = " + orderId);
	}
}
