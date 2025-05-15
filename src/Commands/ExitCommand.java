package Commands;
import Application.*;
public class ExitCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        System.out.println("Exit");
    }
}
