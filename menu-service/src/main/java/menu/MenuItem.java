package menu;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class MenuItem {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is required")
	    @Column(nullable = false)
	    private String name;

	    @NotBlank(message = "Description is required")
	    @Column(nullable = false)
	    private String description;

	    @NotNull(message = "Price is required")
	    @Positive(message = "Price must be greater than 0")
	    @Column(nullable = false)
	    private Double price;

	    @NotBlank(message = "Category is required")
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Category category;

	    @NotNull(message = "Availability must be specified")
	    @Column(nullable = false)
	    private Boolean available = true;

	    public MenuItem() {}

	    public MenuItem(String name, String description, Double price, Category category, Boolean available) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.category = category;
	        this.available = available;
	    }

	    public MenuItem(Long id, String name, String description, Double price, Category category, Boolean available) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.category = category;
	        this.available = available;
	    }

	    // Getters i Setters
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

	    public Category getCategory() {
	        return category;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }

	    public Boolean getAvailable() {
	        return available;
	    }

	    public void setAvailable(Boolean available) {
	        this.available = available;
	    }

	    @Override
	    public String toString() {
	        return "MenuItem{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", description='" + description + '\'' +
	                ", price=" + price +
	                ", category='" + category + '\'' +
	                ", available=" + available +
	                '}';
	    }
}
