package Application;

import Commands.*;

public class CommandFactory {
    public static Command getCommand(String name) {
        switch (name.toLowerCase()) {
            case "open":
                return new OpenCommand();
            case "save":
                return new SaveCommand();
            case "saveas":
                return new SaveAsCommand();
            case "print":
                return new PrintCommand();
            case "create":
                return new CreateCommand();
            case "erase":
                return new EraseCommand();
            case "translate":
                return new TranslateCommand();
            case "within":
                return new WithinCommand();
            case "help":
                return new HelpCommand();
            case "exit":
                return new ExitCommand();
            default:
                return new UnknownCommand(name);
        }
    }
}
