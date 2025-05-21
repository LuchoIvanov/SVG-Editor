package Commands;

import Application.*;
import SVGParser.SVGParser;

public class SaveCommand implements Command{
    /**
     * Updates the current SVG file. Calls the save method from the SVGParser class
     * @param args
     * @param context
     */
    @Override
    public void execute(String[] args, FileContext context) {
        if (context.filename == null) {
            System.out.println("No file opened.");
            return;
        }

        SVGParser.save(context.filename, context.shapes);
        System.out.println("Successfully saved to " + context.filename);
    }
}
