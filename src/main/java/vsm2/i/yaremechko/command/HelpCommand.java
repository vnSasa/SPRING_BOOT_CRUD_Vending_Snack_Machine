package vsm2.i.yaremechko.command;

import org.springframework.stereotype.Component;
import vsm2.i.yaremechko.console.ConsoleWriter;
import vsm2.i.yaremechko.console.handler.ConsoleHandler;

@Component
public class HelpCommand implements Command {

    private final String NAME_COMMAND = "help";

    public HelpCommand() {
        CommandHandler.commands.put(NAME_COMMAND, this);
    }

    @Override
    public void execute(String args) {
        ConsoleWriter.println(ConsoleHandler.HELP);
        for (String command : CommandHandler.commands.keySet()) {
            ConsoleWriter.println("\t"+command);
        }
    }
}
