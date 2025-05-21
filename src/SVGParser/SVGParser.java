package SVGParser;

import Shapes.*;

import java.util.*;
import java.io.*;

public class SVGParser  {
    /**
     * The method reads the SVG file and adds the shapes to the shapes list
     * @param filename - The name of the file that the method will load
     * @return
     */
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

    /**
     * Writes a valid SVG file with the shapes that the user created
     * @param filename
     * @param shapes
     */
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

    /**
     * Parses the rectangle in to an SVG format
     * @param line
     * @return
     */
    private static Rectangle parseRectangle(String line) {
        int x = extractInt(line, "x"), y = extractInt(line, "y"),
                w = extractInt(line, "width"), h = extractInt(line, "height");
        String fill = extractString(line, "fill");
        return new Rectangle(x, y, w, h, fill);
    }

    /**
     * Parses the circle in to an SVG format
     * @param line
     * @return
     */
    private static Circle parseCircle(String line) {
        int cx = extractInt(line, "cx"), cy = extractInt(line, "cy"), r = extractInt(line, "r");
        String fill = extractString(line, "fill");
        return new Circle(cx, cy, r, fill);
    }

    /**
     * Parses the line in to anSVG format
     * @param line
     * @return
     */
    private static Line parseLine(String line) {
        int x1 = extractInt(line, "x1"), y1 = extractInt(line, "y1"),
                x2 = extractInt(line, "x2"), y2 = extractInt(line, "y2");
        String stroke = extractString(line, "stroke");
        return new Line(x1, y1, x2, y2, stroke);
    }

    /**
     * Calls the extractString method to get the text value of an attribute and converts it to an integer
     * @param line
     * @param attr
     * @return
     */
    private static int extractInt(String line, String attr) {
        String v = extractString(line, attr);
        return Integer.parseInt(v);
    }

    /**
     * Extracts attributes from SVG code
     * @param line
     * @param attr
     * @return
     */
    private static String extractString(String line, String attr) {
        int i = line.indexOf(attr + "=\"");
        if (i == -1) return "";
        int start = i + attr.length() + 2;
        int end = line.indexOf("\"", start);
        return line.substring(start, end);
    }
}
