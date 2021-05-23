package vsm2.i.yaremechko.service;

import org.springframework.stereotype.Service;
import vsm2.i.yaremechko.entity.Product;

import java.util.List;

@Service
public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    List<Product> deleteEmptyCategories();
    List<Product> getAllProducts();
    Product findByCategory(String category);
    Product addAmount(Product product);
}
