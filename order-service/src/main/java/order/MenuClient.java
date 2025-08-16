package order;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MenuClient {

	private final WebClient webClient;
	
	public MenuClient(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("http://menu-service").build();
	}
	
	public List<MenuItemDto> getAvailableItems(List<Long> ids){
		return webClient.post()
				.uri("/menu/available/batch")
				.bodyValue(ids)
				.retrieve()
				.bodyToFlux(MenuItemDto.class)
				.collectList()
				.block();
				}
}
