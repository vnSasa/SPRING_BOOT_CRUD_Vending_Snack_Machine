package vsm2.i.yaremechko.service;

import org.springframework.stereotype.Service;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.entity.Purchase;
import vsm2.i.yaremechko.repo.PurchaseRepository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;
    private final ProductService productService;
    public PurchaseServiceImpl(PurchaseRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Override
    public Purchase save(Purchase purchase) {
        if (purchase == null) {
            return null;
        }
        if (purchase.getDate() == null) {
            return null;
        }
        Product productFromDB = productService.findByCategory(purchase.getProduct().getCategory());
        if (productFromDB == null || productFromDB.getAmount() == 0) {
            return null;
        }
        purchase.setProduct(productFromDB);
        Purchase purchaseFromDB = repository.save(purchase);
        productFromDB.decrementAmount();
        productService.update(productFromDB);
        return purchaseFromDB;
    }

    @Override
    public Map<Product, Integer> getReportByDate(LocalDate date) {
        List<Purchase> purchases = repository.findPurchaseByDate(date);
        return getReport(purchases);
    }
    @Override
    public Map<Product, Integer> getReportByYearMonth(YearMonth yearMonth) {
        List<Purchase> purchases = repository.findPurchasesByDateBetween(
                yearMonth.atDay(1),
                yearMonth.atEndOfMonth());
        return getReport(purchases);
    }
    private Map<Product, Integer> getReport(List<Purchase> purchases) {
        Map<Product, Integer> report = new TreeMap<>();
        for (Purchase purchase : purchases) {
            report.computeIfPresent(purchase.getProduct(), (key, val) -> val += 1);
            report.putIfAbsent(purchase.getProduct(), 1);
        }
        return report;
    }

}
