package Commands;

import Application.*;

public class UnknownCommand implements Command{
    private String name;

    public UnknownCommand(String name) {
        this.name = name;
    }

    /**
     * Displays a message that the command that the user has written is incorrect
     * @param args
     * @param context
     */
    @Override
    public void execute(String[] args, FileContext context) {
        System.out.println("Uknown command " + name);
    }
}
