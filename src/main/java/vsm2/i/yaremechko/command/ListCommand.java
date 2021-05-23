package vsm2.i.yaremechko.command;

import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.console.handler.ConsoleHandler;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.service.ProductService;

import java.util.List;

@Component
public class ListCommand implements Command{
    public static final String COMMAND_NAME = "list";
    private final ProductService productService;

    public ListCommand(ProductService productService) {
        this.productService = productService;
        CommandHandler.commands.put(COMMAND_NAME, this);
    }

    @Override
    public void execute(String args) {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            ConsoleWriter.println(ConsoleHandler.EMPTY_LIST);
        }
        else {
            for (Product  product : products) {
                ConsoleWriter.println(product.toString() + " " + product.getAmount());
            }
        }

    }
}
