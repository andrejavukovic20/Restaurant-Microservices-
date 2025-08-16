package restaurant.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.models.MenuItem;
import restaurant.services.MenuItemService;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
	private final MenuItemService menuItemService;

	public MenuItemController(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}
	
	@GetMapping
	public List<MenuItem> getAll() {
		return menuItemService.getAllMenuItem();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
	    try {
	        MenuItem item = menuItemService.getMenuItemById(id);
	        return ResponseEntity.ok(item);
	    } catch (RuntimeException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(ex.getMessage());
	    }
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody MenuItem item) {
		MenuItem saved = menuItemService.createMenuItem(item);
		return ResponseEntity.status(201).body("Menu item added with ID: " + saved.getId());
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody MenuItem item) {
		MenuItem updated = menuItemService.updateMenuItem(id, item);
		return ResponseEntity.ok("Menu item updated with ID: " + updated.getId());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
	    try {
	        menuItemService.deleteMenuItem(id);
	        return ResponseEntity.ok("Menu item deleted: ID " + id);
	    } catch (RuntimeException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(ex.getMessage());
	    }
	}
}
