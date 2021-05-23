package vsm2.i.yaremechko.service;

import org.springframework.stereotype.Service;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.entity.Purchase;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Map;

@Service
public interface PurchaseService {
    Purchase save(Purchase purchase);
    Map<Product, Integer> getReportByYearMonth(YearMonth yearMonth);
    Map<Product, Integer> getReportByDate(LocalDate date);
}
