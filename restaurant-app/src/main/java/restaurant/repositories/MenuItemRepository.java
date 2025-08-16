package restaurant.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.models.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
