package order;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	private List<Long> menuItemIds;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private LocalDateTime createdAt;

	public Order() {
	}
	
	public Order(Long id, List<Long> menuItemIds, OrderStatus status, LocalDateTime createdAt) {
		this.id = id;
		this.menuItemIds = menuItemIds;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	public Order(List<Long> menuItemIds) {
		this.menuItemIds = menuItemIds;
		this.status = status;
		this.createdAt  = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getMenuItemIds() {
		return menuItemIds;
	}

	public void setMenuItemIds(List<Long> menuItemIds) {
		this.menuItemIds = menuItemIds;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
