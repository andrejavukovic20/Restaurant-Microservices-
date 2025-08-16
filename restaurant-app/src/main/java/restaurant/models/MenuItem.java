package restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "menu")
public class MenuItem {
	@Id
	@GeneratedValue
	private Long id;
	
    @Column(nullable = false)
	private String name;
    
    @Column(nullable = false)
	private String description;
    
    @Column(nullable = false)
	private Double price;
    
    public MenuItem() {
    	
    }
    public MenuItem(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

    public MenuItem(Long id, String name, String description, Double price) {
    	this.id = id;
    	this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
    
}
