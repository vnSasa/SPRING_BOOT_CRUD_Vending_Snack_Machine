package vsm2.i.yaremechko.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.console.handler.ConsoleHandler;
import vsm2.i.yaremechko.entity.Product;
import vsm2.i.yaremechko.entity.Purchase;
import vsm2.i.yaremechko.exception.ProductParseException;
import vsm2.i.yaremechko.exception.PurchaseParseException;
import vsm2.i.yaremechko.parser.ProductParser;
import vsm2.i.yaremechko.parser.PurchaseParser;
import vsm2.i.yaremechko.service.PurchaseService;

import java.time.LocalDate;

@Component
public class PurchaseCommand implements Command {

    public static final String COMMAND_NAME = "purchase";
    private final PurchaseService purchaseService;
    private final PurchaseParser purchaseParser;
    private final ProductParser productParser;

    public PurchaseCommand(PurchaseService purchaseService,
                           @Qualifier("purchaseParserImpl") PurchaseParser purchaseParser,
                           ProductParser productParser) {
        this.purchaseService = purchaseService;
        this.purchaseParser = purchaseParser;
        this.productParser = productParser;
        CommandHandler.commands.put(COMMAND_NAME, this);
    }
    @Override
    public void execute(String args) {
        String category;
        Purchase purchase = null;
        LocalDate date = null;
        try {
            category = productParser.parseCategory(args);
            date = purchaseParser.parseDate(args);
            purchase = new Purchase(new Product(category), date);
        } catch (ProductParseException | PurchaseParseException e) {
            ConsoleWriter.println(e.getMessage());
        }
        purchase = purchaseService.save(purchase);
        if (purchase == null) {
            ConsoleWriter.println(ConsoleHandler.NOTHING_TO_BUY);
        }
        else {
            ConsoleWriter.println(purchase.toString());
        }

    }
}
