package Commands;

import Application.*;
import Shapes.Shape;

public class WithinCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        if (args.length < 2) {
            System.out.println("Usage: within <rectangle|circle> [params]");
            return;
        }
        String type = args[1];

        if (type.equalsIgnoreCase("rectangle")) {
            if (args.length < 6) {
                System.out.println("Usage: within rectangle <x> <y> <width> <height>");
                return;
            }

            int x = Integer.parseInt(args[2]);
            int y = Integer.parseInt(args[3]);
            int width = Integer.parseInt(args[4]);
            int height = Integer.parseInt(args[5]);

            boolean found = false;
            for (int i = 0; i < context.shapes.size(); i++) {
                Shape shape = context.shapes.get(i);
                if (shape.isWithinRectangle(x, y, width, height)) {
                    System.out.println((i + 1) + ". " + shape);
                    found = true;
                }
            }

            if (!found) System.out.println("No figures are located within rectangle " + x + " " + y + " " + width + " " + height);

        } else if (type.equalsIgnoreCase("circle")) {
            if (args.length < 5) {
                System.out.println("Usage: within circle <cx> <cy> <r>");
                return;
            }

            int cx = Integer.parseInt(args[2]);
            int cy = Integer.parseInt(args[3]);
            int r = Integer.parseInt(args[4]);

            boolean found = false;
            for (int i = 0; i < context.shapes.size(); i++) {
                Shape shape = context.shapes.get(i);
                if (shape.isWithinCircle(cx, cy, r)) {
                    System.out.println((i + 1) + ". " + shape);
                    found = true;
                }
            }

            if (!found) System.out.println("No figures are located within circle " + cx + " " + cy + " " + r);

        } else {
            System.out.println("Unknown region type: " + type);
        }
    }
}
