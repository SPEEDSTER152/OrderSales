package Repositories;

import entities.OrderItem;
import entities.ProductStock;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductStockRepository extends JpaRepositoriesAutoConfiguration<OrderItem, UUID> {

    static Optional<Object> findByid(UUID idproduct) {
    }

    public ProductStock findByNameProduct(String nameProduct);

    Optional<Object> findById(UUID idProductStock);

    static void save(ProductStock stock) {

    }

    boolean existsById(UUID idproduct);

    List<ProductStock> findall();
}
