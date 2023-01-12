package Controllers;

import Services.AddressService;
import Services.ProductStockService;
import entities.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Stock")
public class ProductStockController {

    @Autowired
    private ProductStockService productStockService;

    @PostMapping
    public ResponseEntity<ProductStock> create(@RequestBody ProductStock productStock) {
        try {
            ProductStock createProductStock = ProductStockService.save(productStock);
            return new ResponseEntity<>(createProductStock, HttpStatus.CREATED);
        } catch (ProductStockExistException exception) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
        @PatchMapping("/increase/{id}")
           public ResponseEntity<ProductStock> increaseQuantity(@PathVariable  UUID idStockProduct,
                                                                @RequestBody ProductStock productStock){
        ProductStock updateQuantityOfProductStock = ProductStockService
                .increaseQuantityOfProductStock(productStock);
        return new ResponseEntity<>(updateQuantityOfProductStock, HttpStatus.OK);
        }
 @GetMapping("{idProdductStock}")
    public ResponseEntity<ProductStock> findbyId(@PathVariable("idProductStock") UUID idProductStock){
        return new ResponseEntity<>(ProductStockService.findById(idProductStock),HttpStatus.OK);
 }
 public ResponseEntity<List<ProductStock>> findAll(){
        return new ResponseEntity<>(productStockService.findall(), HttpStatus.OK);
 }
}
