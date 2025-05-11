package Commands;

import Application.*;

public class UnknownCommand implements Command{
    private String name;

    public UnknownCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(String[] args, FileContext context) {
        System.out.println("Uknown command " + name);
    }
}
