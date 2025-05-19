package SVGParser;

import Shapes.*;

import java.util.*;
import java.io.*;

public class SVGParser  {
    public static List<Shape> load(String filename) {
        List<Shape> shapes = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.startsWith("<rect")) shapes.add(parseRectangle(line));
                else if (line.startsWith("<circle")) shapes.add(parseCircle(line));
                else if (line.startsWith("<line")) shapes.add(parseLine(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }
        return shapes;
    }

    public static void save(String filename, List<Shape> shapes) {
        try {
            FileWriter writer = new FileWriter(filename);

            writer.write("<?xml version=\"1.0\" standalone=\"no\"?>\n");
            writer.write("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" ");
            writer.write("\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
            writer.write("<svg>\n");

            for (Shape shape : shapes) {
                writer.write("  " + shape.toSvg() + "\n");
            }

            writer.write("</svg>\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }
    }
    private static Rectangle parseRectangle(String line) {
        int x = extractInt(line, "x"), y = extractInt(line, "y"),
                w = extractInt(line, "width"), h = extractInt(line, "height");
        String fill = extractString(line, "fill");
        return new Rectangle(x, y, w, h, fill);
    }

    private static Circle parseCircle(String line) {
        int cx = extractInt(line, "cx"), cy = extractInt(line, "cy"), r = extractInt(line, "r");
        String fill = extractString(line, "fill");
        return new Circle(cx, cy, r, fill);
    }

    private static Line parseLine(String line) {
        int x1 = extractInt(line, "x1"), y1 = extractInt(line, "y1"),
                x2 = extractInt(line, "x2"), y2 = extractInt(line, "y2");
        String stroke = extractString(line, "stroke");
        return new Line(x1, y1, x2, y2, stroke);
    }

    private static int extractInt(String line, String attr) {
        String v = extractString(line, attr);
        return Integer.parseInt(v);
    }

    private static String extractString(String line, String attr) {
        int i = line.indexOf(attr + "=\"");
        if (i == -1) return "";
        int start = i + attr.length() + 2;
        int end = line.indexOf("\"", start);
        return line.substring(start, end);
    }
}
