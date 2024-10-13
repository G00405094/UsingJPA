package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product) {
        Product updatedProduct = productRepository.getReferenceById(id);
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductDescription(product.getProductDescription());
        updatedProduct.setProductCode(product.getProductCode());
        updatedProduct.setProductPrice(product.getProductPrice());
        productRepository.save(updatedProduct);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

}
