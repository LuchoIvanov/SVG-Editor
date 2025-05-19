package Commands;
import Application.*;
import java.io.*;
import SVGParser.SVGParser;

public class OpenCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
        if (args.length < 2) {
            System.out.println("Usage: open <filename>");
            return;
        }
        String filename = args[1];
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }

        context.shapes = SVGParser.load(filename);
        context.filename = filename;
        System.out.println("Successfully opened " + filename);
    }
}
