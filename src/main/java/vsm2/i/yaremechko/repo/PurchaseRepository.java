package vsm2.i.yaremechko.repo;

import org.springframework.data.repository.CrudRepository;
import vsm2.i.yaremechko.entity.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    List<Purchase> findPurchaseByDate(LocalDate date);
    List<Purchase> findPurchasesByDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
