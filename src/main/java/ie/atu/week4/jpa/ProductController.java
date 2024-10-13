package ie.atu.week4.jpa;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public Product addTask(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }

    @DeleteMapping("/remove/{id}")
    public void removeProduct(@Valid @PathVariable Long id) {
        productService.removeProduct(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @Valid @RequestBody Product product) {
        productService.updateProduct(id, product);
        return product;
    }
}
