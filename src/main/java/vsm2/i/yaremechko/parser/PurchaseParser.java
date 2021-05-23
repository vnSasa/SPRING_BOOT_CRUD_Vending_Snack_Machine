package vsm2.i.yaremechko.parser;

import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.exception.PurchaseParseException;

import java.time.LocalDate;
import java.time.YearMonth;

@Component
public interface PurchaseParser {
    YearMonth parseReportYearMonth(String args) throws PurchaseParseException;
    LocalDate parseDate(String args) throws PurchaseParseException;
    boolean isYearMonthFormat(String args);
}
