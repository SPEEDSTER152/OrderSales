package Repositories;

import entities.Customer;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepositoriesAutoConfiguration<Customer, UUID> {
    static List<Customer> findall() {
    }

    static Optional<Object> findById(UUID idcustomer);

    boolean existsById(UUID idcustomer);
}
