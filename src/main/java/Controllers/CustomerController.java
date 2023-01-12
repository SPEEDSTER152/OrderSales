package Controllers;

import Services.AddressService;
import Services.CustomerService;
import entities.Address;
import entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer){
        Customer customer =  CustomerService.create(newCustomer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/address/{idCustomer}")
    public ResponseEntity<Address> createAddress(@RequestBody Address newAddress,
                                                 @PathVariable UUID idCustomer){
        newAddress.setIdCustomer(idCustomer);
        Address address = AddressService.create(newAddress);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findall(){
        return new ResponseEntity<>(customerService.findall(), HttpStatus.OK);
    }

    @GetMapping("/address/{idCustomer}")
    public ResponseEntity<Address> findByIdCustomer(@PathVariable("idcustomer") UUID idCustomer){
        return new ResponseEntity<>(addressService.findByIdCustomer(idCustomer),HttpStatus.OK);
    }
}
