package Commands;

import Application.FileContext;
import SVGParser.SVGParser;

public class SaveAsCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        if (args.length < 2) {
            System.out.println("Usage: saveas <filename>");
            return;
        }
        SVGParser.save(args[1], context.shapes);
        context.filename = args[1];
        System.out.println("Successfully saved as " + args[1]);
    }
}
