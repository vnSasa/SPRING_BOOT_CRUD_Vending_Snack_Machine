package vsm2.i.yaremechko.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.console.handler.ConsoleHandler;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.exception.ProductParseException;
import vsm2.i.yaremechko.parser.ProductParser;
import vsm2.i.yaremechko.service.ProductService;

@Component
public class AddItemCommand implements Command{

    public static final String COMMAND_NAME = "addItem";
    private final ProductService productService;
    private final ProductParser parser;

    public AddItemCommand(ProductService productService,
                         @Qualifier("productParserImpl") ProductParser parser) {
        this.productService = productService;
        this.parser = parser;
        CommandHandler.commands.put(COMMAND_NAME, this);
    }
    @Override
    public void execute(String args) {
        boolean isExist = true;
        Product product = null;
        Product productFromDB;
        try {
            String category = parser.parseCategory(args);
            int amount = parser.parseAmount(args);
            product = new Product(category, null, amount);
        } catch (ProductParseException e) {
            isExist = false;
            ConsoleWriter.println(e.getMessage());
        }
        productFromDB = productService.addAmount(product);
        if (productFromDB != null) {
            ConsoleWriter.println(productFromDB.toString() + " " + productFromDB.getAmount());
        }
        else if (isExist){
            ConsoleWriter.println(ConsoleHandler.NO_EXISTING_CATEGORY);
        }
    }
}
