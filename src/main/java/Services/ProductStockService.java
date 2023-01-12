package Services;

import Repositories.ProductStockRepository;
import entities.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductStockService {

    @Autowired
    static
    ProductStockRepository productStockRepository;



    private static boolean productstockAlredyExists(List<ProductStock> productStocks,
                                                    ProductStock productStock){
        Optional<ProductStock> maybeProductStock = productStocks.stream()
                .filter(ps -> ps.getIdProduct() == productStock.getIdProduct())
                .findFirst();
        return maybeProductStock.isEmpty();
    }

    public static ProductStock save(ProductStock productStock)  {
        List<ProductStock> productStocks = productStockRepository.findall();
        if(productstockAlredyExists(productStocks,productStock)){
        }
    ProductStockRepository.save(productStock);
        return productStock;
    }
    public static ProductStock increaseQuantityOfProductStock(ProductStock productStock){
        int increaseQuantity = productStock.getQuantityStock();
        ProductStock persistProductStock = (ProductStock) productStockRepository
                .findById(productStock.getIdProduct()).orElseThrow();
        Object increaseQuantity1 = persistProductStock.increaseQuantity;
        return productStock.save(persistProductStock);

    }

    public List<ProductStock> findall(){
        return productStockRepository.findall();
 }
 public static ProductStock findById(UUID idProduct){
        return (ProductStock) ProductStockRepository.findByid(idProduct).orElseThrow();
 }
 public ProductStock findByName (String nameProduct){
        return productStockRepository.findByNameProduct(nameProduct);
 }
}
