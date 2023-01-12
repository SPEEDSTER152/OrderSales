package Services;

import Repositories.OrderItemRepository;
import Repositories.ProductStockRepository;
import entities.OrderItem;
import entities.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    public boolean availableQuantityVerification(UUID idproduct, int quantity) {
        ProductStock productStock = (ProductStock) ProductStockRepository.findByid(idproduct).orElseThrow();
        if (productStockRepository.existsById(idproduct)) {
            if (quantity <= productStock.getQuantityStock() && quantity > 0) {
                return true;
            }
        }
        return false;
    }

    public void updateProductStockByOrderItem(OrderItem orderItem, ProductStock productStock) {
        ProductStock stock = new ProductStock(orderItem.getIdProductStock(),
                productStock.getQuantityStock());
        productStockRepository.save(stock);
    }
}
