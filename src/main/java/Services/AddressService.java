package Services;

import Repositories.AddressRepository;
import entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

import java.util.UUID;

public class AddressService {


    @Autowired
    static AddressRepository addressRepository;

    public HttpStatusCode findall;


    public static Address create(Address address){
        addressRepository.save(address);
        return address;
    }
    public Address findByIdCustomer(UUID IdCustomer){
        return addressRepository.findByIdCustomer(IdCustomer);
    }
}
