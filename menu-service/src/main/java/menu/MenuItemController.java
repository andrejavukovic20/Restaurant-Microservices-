package menu;

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

import jakarta.validation.Valid;

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
	   public ResponseEntity<String> create(@Valid @RequestBody MenuItem item) {
        MenuItem saved = menuItemService.createMenuItem(item);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Menu item added with ID: " + saved.getId());
    }
	
	@PutMapping("/{id}") 
	 public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody MenuItem item) {
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
	
	@GetMapping("/category/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable String category) {
	    List<MenuItem> items = menuItemService.getByCatgory(category);

	    if (items.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("No items found for category: " + category.toUpperCase());
	    }

	    return ResponseEntity.ok(items);
	}
	
	@GetMapping("/available")
	public List<MenuItem> getAvailableItems(){
		return menuItemService.getAvailableItems();
	}
	
	@PostMapping("available/batch") 
	public ResponseEntity<List<MenuItem>> getAvilableItemsByIds(@RequestBody  List<Long> ids){
		if (ids == null || ids.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		List<MenuItem> items = menuItemService.getAvailaleItemsByIds(ids);
		return ResponseEntity.ok(items);
	}
}
