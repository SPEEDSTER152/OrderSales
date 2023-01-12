package entities;

import java.util.UUID;

public class OrderItem {

    private Integer idOrderItem;

    private Order order;

    private UUID idProductStock;

    private int quantityItem;

    private Double totalPrice;

    public OrderItem(Integer idOrderItem, Order order, UUID idProductStock, int quantityItem, Double totalPrice) {
        this.idOrderItem = idOrderItem;
        this.order = order;
        this.idProductStock = idProductStock;
        this.quantityItem = quantityItem;
        this.totalPrice = totalPrice;
    }

    public Integer getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UUID getIdProductStock() {
        return idProductStock;
    }

    public void setIdProductStock(UUID idProductStock) {
        this.idProductStock = idProductStock;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
