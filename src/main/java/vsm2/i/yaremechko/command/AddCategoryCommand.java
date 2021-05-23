package vsm2.i.yaremechko.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.exception.ProductParseException;
import vsm2.i.yaremechko.parser.ProductParser;
import vsm2.i.yaremechko.service.ProductService;

@Component
public class AddCategoryCommand implements Command{

    public static final String COMMAND_NAME = "addCategory";
    private final ProductService productService;
    private final ProductParser parser;

    public AddCategoryCommand(ProductService productService,
                              @Qualifier("productParserImpl") ProductParser parser) {
        this.productService = productService;
        this.parser = parser;
        CommandHandler.commands.put(COMMAND_NAME, this);
    }

    @Override
    public void execute(String args) {
        Product product = null;
        try {
            String category = parser.parseCategory(args);
            double price = parser.parsePrice(args);
            if (parser.isAmountPresent(args)) {
                int amount = parser.parseAmount(args);
                product = new Product(category, price, amount);
            }
            else {
                product = new Product(category, price);
            }
        } catch (ProductParseException e) {
            ConsoleWriter.println(e.getMessage());
        }
        Product productFromDB = productService.create(product);
        if (productFromDB != null) {
            ConsoleWriter.println(productFromDB.toString() + " " + productFromDB.getAmount());
        }
    }
}
