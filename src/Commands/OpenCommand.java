package Commands;
import Application.*;
import java.io.*;
import SvgParser.SVGParser;

public class OpenCommand implements Command{
    @Override
    public void execute(String[] args, FileContext context) {
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
