package Commands;

import Application.FileContext;
import SvgParser.SVGParser;

public class SaveAsCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        SVGParser.save(args[1], context.shapes);
        context.filename = args[1];
        System.out.println("Successfully saved as " + args[1]);
    }
}
