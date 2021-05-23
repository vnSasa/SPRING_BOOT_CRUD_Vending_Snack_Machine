package vsm2.i.yaremechko.parser;

import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.exception.ProductParseException;

@Component
public interface ProductParser {
    String parseCategory(String args) throws ProductParseException;
    double parsePrice(String args) throws ProductParseException;
    int parseAmount(String args) throws ProductParseException;
    boolean isAmountPresent(String args);
}
