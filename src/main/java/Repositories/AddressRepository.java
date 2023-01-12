package Repositories;

import entities.Address;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.UUID;

public interface AddressRepository extends JpaRepositoriesAutoConfiguration<Address, UUID> {

    public Address findByIdCustomer(UUID idCustomer);

    void save(Address address);
}
