package Commands;
import Application.*;

public class HelpCommand implements Command{

    @Override
    public void execute(String[] args, FileContext context) {
        System.out.println("Supported commands: open, print, create, erase, translate, within, save, saveas, close, help, exit");
    }
}
