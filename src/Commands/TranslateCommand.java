package Commands;

import Application.*;

public class TranslateCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        int dx = 0;
        int dy = 0;

        for (String part : args) {
            if (part.startsWith("horizontal=")) dx = Integer.parseInt(part.split("=")[1]);
            if (part.startsWith("vertical=")) dy = Integer.parseInt(part.split("=")[1]);
        }

        context.shapes.get(Integer.parseInt(args[1]) - 1).translate(dx, dy);
        System.out.println("Shape translated successfully");
    }
}
