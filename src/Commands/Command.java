package Commands;

import Application.FileContext;

public interface Command {
    void execute(String[] args, FileContext context);
}