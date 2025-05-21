package Shapes;

public class Rectangle implements Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private String fill;

    public Rectangle(int x, int y, int width, int height, String fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return String.format("rectangle %d %d %d %d %s", x, y, width, height, fill);
    }

    @Override
    public boolean isWithinRectangle(int rx, int ry, int rw, int rh) {
        return x >= rx && y >= ry && (x + width) <= (rx + rw) && (y + height) <= (ry + rh);
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int r) {
        double[] points = {x, y, x+width, y, x, y+height, x+width, y+height};
        for (int i = 0; i < points.length; i += 2) {
            double dx = points[i] - cx;
            double dy = points[i+1] - cy;
            if (dx*dx + dy*dy > r*r) return false;
        }
        return true;
    }
    @Override
    public String toSvg() {
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\"/>",
                x, y, width, height, fill);
    }
}
