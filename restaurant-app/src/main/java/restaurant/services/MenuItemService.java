package restaurant.services;

import java.util.List;

import org.springframework.stereotype.Service;

import restaurant.models.MenuItem;
import restaurant.repositories.MenuItemRepository;

@Service
public class MenuItemService {
	private final MenuItemRepository menuItemRepository;

	public MenuItemService(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}
	
	public List<MenuItem> getAllMenuItem(){
		return menuItemRepository.findAll();
	}
	
	public MenuItem getMenuItemById(Long id) {
		return menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
	}
	
	public MenuItem createMenuItem(MenuItem item) {
		if (item.getName() == null || item.getName().isBlank()) {
			throw new IllegalArgumentException("Name is required");
		}
		if (item.getPrice() <= 0) {
			throw new IllegalArgumentException("Price must be positive!");
		}
		
		return menuItemRepository.save(item);
	}
	
	public MenuItem updateMenuItem(Long id, MenuItem item) {
		MenuItem existing = getMenuItemById(id);
		
		if(item.getName() == null || item.getName().isBlank()) {
			throw new IllegalArgumentException("Name is required.");
		}
		if (item.getPrice() <= 0) {
			throw new IllegalArgumentException("Price must be greater than zero!");
		}
		
		existing.setName(item.getName());
		existing.setDescription(item.getDescription());
		existing.setPrice(item.getPrice());
		
		return menuItemRepository.save(existing); 
	}
	
	public void deleteMenuItem(Long id) {
		if (!menuItemRepository.existsById(id)) {
			throw new RuntimeException("Menu item with ID " + id + " does not exist.");
		}
	
		menuItemRepository.deleteById(id); 
	}
}
