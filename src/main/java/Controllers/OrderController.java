package Controllers;

import Services.AddressService;
import Services.CustomerService;
import Services.OrderItemService;
import Services.OrderService;
import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order newOrder) throws ClassNotFoundException {
        System.out.println("Order Foi Chamada no Controller");

        if(newOrder.getIdcustomer() != null){
            Order createOrder = orderService.save(newOrder);
            return new ResponseEntity<>(createOrder, HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Nao foi Encontrado");
    }
}
