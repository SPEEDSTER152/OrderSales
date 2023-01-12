package Services;

import Repositories.CustomerRepository;
import Repositories.OrderItemRepository;
import Repositories.OrderRepository;
import Repositories.ProductStockRepository;
import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Autowired
    OrderItemService orderItemService;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order save (Order order) throws ClassNotFoundException {

        Customer customer = (Customer) customerRepository.findById(order.getIdcustomer()).orElseThrow();
        if (!customerRepository.existsById(order.getIdcustomer())) {
            throw new ClassNotFoundException("Cliente Não Encontrado !");
        } else {

            order.setIdcustomer(customer.getIdCustomer());

            // Apenas para confirmar o acesso a CustomerRepository
            System.out.println(customer.getNameCustomer());

            System.out.println("OrderItem foi chamada em OrderService");

            Iterator<OrderItem> oi = order.getItems().iterator();

            while (oi.hasNext()){
                OrderItem orderItem = oi.next();
                ProductStock product = (ProductStock) productStockRepository.findById
                        (orderItem.getIdProductStock()).orElseThrow();
                if (orderItemService.availableQuantityVerification( orderItem.getIdProductStock(),
                        orderItem.getQuantityItem())) {
                    product.setQuantityStock(product.getQuantityStock() - orderItem.getQuantityItem());

                    if (order.getDiscountOrder() <= product.getMaxDiscountPercentage()) {
                        orderItem.setTotalPrice(product.getPriceProduct() * orderItem.getQuantityItem());
                    } else {
                        throw new ClassNotFoundException("Desconto Acima do Permitido !");
                    }
                    orderItem.setOrder(order);
                    orderItem.setIdProductStock(orderItem.getIdProductStock());
                    order.setTotalpriceorder(order.getTotalpriceorder() + orderItem.getTotalPrice());
                    orderItemService.updateProductStockByOrderItem(orderItem, product);

                } else {
                    oi.remove();
                    throw new ClassNotFoundException("Produto Não Disponível no Estoque!");
                }
            }
            if (!order.getItems().isEmpty()){
                orderRepository.save(order);
            }
            return order;
        }
    }

    public Order update (Order order) throws ClassNotFoundException{

        Order ord = (Order) orderRepository.findById(order.getIdorder()).orElseThrow();
        if (!orderRepository.existsById(order.getIdorder())) {
            throw new ClassNotFoundException("Pedido de Venda Não Encontrado !");
        }else{
            orderRepository.save(order);
        }
        return order;
    }
    public List<Order> findAll(){

        return orderRepository.findAll();
    }
    public Order findById(UUID orderId){

        return (Order) orderRepository.findById(orderId).orElseThrow();
    }
}