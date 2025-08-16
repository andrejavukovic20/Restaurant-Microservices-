package restaurant.services;

import java.util.List;

import org.springframework.stereotype.Service;

import restaurant.models.Order;
import restaurant.repositories.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
	}
	
	public Order createOrder(Order order) {
		order.setStatus("CREATED");
		order.setCreatedAt(java.time.LocalDateTime.now());
		return orderRepository.save(order);
	}
	
	public Order updateOrder(Long id, Order newOrder) {
		Order existing = getOrderById(id);
		existing.setMenuItemIds(newOrder.getMenuItemIds());
		return orderRepository.save(existing);
	}
	
	public void deleteOrder(Long id) {
		if (!orderRepository.existsById(id)) {
			throw new RuntimeException("Order with ID " + id + " not found");
		}
		
		orderRepository.deleteById(id);
	}
}
