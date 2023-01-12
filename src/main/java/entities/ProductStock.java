package entities;

import java.util.UUID;

public class ProductStock {

    public Object increaseQuantity;
    private UUID idProduct;

    private String nameProduct;

    private int quantityStock;

    private Double priceProduct;

    private Double maxDiscountPercentage;

    public ProductStock(UUID idProduct, int quantityStock) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantityStock = quantityStock;
        this.priceProduct = priceProduct;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public ProductStock save(ProductStock persistProductStock) {
        return save(persistProductStock);
    }
}
