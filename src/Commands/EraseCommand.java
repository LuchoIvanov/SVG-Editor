package Commands;
import Application.*;
import Shapes.*;

public class EraseCommand implements Command{

    @Override
    public void execute(String[] args, FileContext context) {
        if (args.length < 2) {
            System.out.println("Usage: erase <index>");
            return;
        }
        int index = Integer.parseInt(args[1]);

        if (index < 1 || index > context.shapes.size()) {
            System.out.println("No such index");
        } else {
            Shape removed = context.shapes.get(index - 1);
            context.shapes.remove(index - 1);
            System.out.println("Erased a " + removed);
        }
    }
}
