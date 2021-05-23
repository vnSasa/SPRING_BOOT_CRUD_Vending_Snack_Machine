package vsm2.i.yaremechko.repo;

import org.springframework.data.repository.CrudRepository;
import vsm2.i.yaremechko.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findProductByCategory(String category);
    Product findProductByCategoryAndDeleteAtIsNull(String category);
    List<Product> findAllByAmountAndDeleteAtIsNull(Integer amount);
    List<Product> findAllByDeleteAtIsNull();
    List<Product> findAllByAmount(Integer i);
}
