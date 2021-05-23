package vsm2.i.yaremechko.command;

import org.springframework.stereotype.Component;

@Component
public interface Command {
    void execute(String args);
}
