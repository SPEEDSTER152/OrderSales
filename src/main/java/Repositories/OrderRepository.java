package Repositories;

import entities.Order;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepositoriesAutoConfiguration<Order, UUID> {
    Optional<Object> findById(UUID orderId);

    List<Order> findAll();

    boolean existsById(UUID idorder);

    void save(Order order);
}
