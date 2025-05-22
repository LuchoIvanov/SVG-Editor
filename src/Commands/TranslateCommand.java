package Commands;

import Application.*;
import Shapes.Shape;

public class TranslateCommand implements Command{
    /**
     * Updates the position of a given shape
     * @param args - The position offset the user wishes to create
     * @param context
     */
    @Override
    public void execute(String[] args, FileContext context) {
        int dx = 0;
        int dy = 0;
        int index = -1;

        for (int i = 1; i < args.length; i++) {
            String part = args[i];
            if (part.startsWith("horizontal=")) {
                dx = Integer.parseInt(part.split("=")[1]);
            } else if (part.startsWith("vertical=")) {
                dy = Integer.parseInt(part.split("=")[1]);
            } else index = Integer.parseInt(part);
        }

        if (index == -1) {
            for (Shape shape : context.shapes) {
                shape.translate(dx, dy);
            }
            System.out.println("Translated all figures");
        } else if (index >= 1 && index <= context.shapes.size()) {
            context.shapes.get(index - 1).translate(dx, dy);
            System.out.println("Translated shape " + index);
        } else {
            System.out.println("Invalid shape index: " + index);
        }
    }
}
