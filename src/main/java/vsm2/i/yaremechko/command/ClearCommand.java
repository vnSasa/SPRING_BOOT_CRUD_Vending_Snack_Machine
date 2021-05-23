package vsm2.i.yaremechko.command;

import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.console.handler.ConsoleHandler;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.service.ProductService;

import java.util.List;

@Component
public class ClearCommand implements Command {

    public static final String COMMAND_NAME = "clear";
    private final ProductService productService;

    public ClearCommand(ProductService productService) {
        this.productService = productService;
        CommandHandler.commands.put(COMMAND_NAME, this);
    }

    @Override
    public void execute(String args) {
        List<Product> products = productService.deleteEmptyCategories();
        if (products.isEmpty())
            ConsoleWriter.println(ConsoleHandler.CLEAR_EMPTY);
        else{
            for (Product product : products) {
                ConsoleWriter.println(product.toString());
            }
        }

    }
}
