package restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
