package restaurant.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
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
	
	private List<Long> menuItemIds;
	
	private String status;
	
	private LocalDateTime createdAt;

	
	public Order(Long id, List<Long> menuItemIds, String status, LocalDateTime createdAt) {
		this.id = id;
		this.menuItemIds = menuItemIds;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	public Order(List<Long> menuItemIds) {
		this.menuItemIds = menuItemIds;
		this.status = "CREATED";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
