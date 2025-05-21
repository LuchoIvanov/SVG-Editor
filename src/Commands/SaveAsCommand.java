package Commands;

import Application.FileContext;
import SVGParser.SVGParser;

public class SaveAsCommand implements Command{
    /**
     * Takes a filename from the user and calls the save method from the SVGParser class
     * Creates a separate file from the one that is currently opened
     * @param args - The name of the file the user wishes to create
     * @param context
     */
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
