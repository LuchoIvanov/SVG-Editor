package Commands;

import Application.*;
import Shapes.*;

public class PrintCommand implements Command{
    /**
     * Displays the shapes and their parameters from the shapes list
     * @param args
     * @param context
     */
    @Override
    public void execute(String[] args, FileContext context) {
        if (context.shapes.isEmpty()) {
            System.out.println("No shapes.");
            return;
        }
        for(int i = 0; i < context.shapes.size(); i++){
            System.out.printf("%d. %s \n", i + 1, context.shapes.get(i));
        }
    }
}
