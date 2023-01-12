package Repositories;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

public interface OrderItemRepository extends JpaRepositoriesAutoConfiguration<OrderItem, Integer> {
}
