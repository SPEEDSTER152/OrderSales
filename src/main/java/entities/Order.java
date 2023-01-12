package entities;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID idorder;

    private UUID idcustomer;

    private Integer idUser;

    private List<OrderItem> items;

    private String dataOrderEntry;

    private Double discountOrder;

    private Double totalpriceorder;

    private paymentMethod PaymentMethod;

    public Order(){}

    public Order(UUID idorder, UUID idcustomer, Integer idUser,List<OrderItem> items, String dataOrderEntry, Double discountOrder, Double totalpriceorder, PaymentMethod paymentMethod) {
        this.idorder = idorder;
        this.idcustomer = idcustomer;
        this.idUser = idUser;
        this.items = items;
        this.dataOrderEntry = dataOrderEntry;
        this.discountOrder = discountOrder;
        this.totalpriceorder = totalpriceorder;
    }

    public UUID getIdorder() {
        return idorder;
    }

    public void setIdorder(UUID idorder) {
        this.idorder = idorder;
    }

    public UUID getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(UUID idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getDataOrderEntry() {
        return dataOrderEntry;
    }

    public void setDataOrderEntry(String dataOrderEntry) {
        this.dataOrderEntry = dataOrderEntry;
    }

    public Double getDiscountOrder() {
        return discountOrder;
    }

    public void setDiscountOrder(Double discountOrder) {
        this.discountOrder = discountOrder;
    }

    public Double getTotalpriceorder() {
        return totalpriceorder;
    }

    public void setTotalpriceorder(Double totalPriceorder) {
        this.totalpriceorder = totalPriceorder;
    }

    public paymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(paymentMethod paymentMethod) {
        PaymentMethod = paymentMethod;
    }
}
