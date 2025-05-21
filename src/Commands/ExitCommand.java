package Commands;
import Application.*;
public class ExitCommand implements Command{
    /**
     * Exits the program
     * @param args
     * @param context
     */
    @Override
    public void execute(String[] args, FileContext context) {
        System.out.println("Exit");
    }
}
